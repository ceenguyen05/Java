// Casey Nguyen
// 10/21/2024 
// COSC 2425 - 51700 , Professor Martinez 
// Program Purpose : 
// Turns a virtual address to a physical address 
// there will be an output text file of physical addresses 
// ONLY reads from a file called virtual.txt
// page faults if not readable 
// used a queue 

// imports 
import java.io.*;
import java.util.*;

// class to get and return the page and frame numbers 
class PageTableEntry {
    private int pageNumber;
    private int frameNumber;

    public PageTableEntry(int pageNumber, int frameNumber) {
        this.pageNumber = pageNumber;
        this.frameNumber = frameNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getFrameNumber() {
        return frameNumber;
    }
}

// this takes in a generic class to store memory 
// uses the skills of a linked list , hashmap , and hash set 
class MemoryManager {
    private final int FRAME_COUNT = 8; // 2KB / 256B = 8 frames
    private final Queue<Integer> pageQueue;
    private final Map<Integer, Integer> pageTable; // Maps page numbers to frame numbers
    private final Set<Integer> loadedPages;
    private int framePointer;
    private int pageFaults;
    private int totalAccesses;
    private int hits;
    
    // initlaizes 
    public MemoryManager() {
        this.pageQueue = new LinkedList<>();
        this.pageTable = new HashMap<>();
        this.loadedPages = new HashSet<>();
        this.framePointer = 0;
        this.pageFaults = 0;
        this.totalAccesses = 0;
        this.hits = 0;
    }

// takes the arguement 
// page fault handling 
    public int translateAddress(int virtualAddress) {
        totalAccesses++;
        int pageSize = 256;
        int pageNumber = virtualAddress / pageSize;
        int offset = virtualAddress % pageSize;

        if (loadedPages.contains(pageNumber)) {
            hits++;
        } else {
            handlePageFault(pageNumber);
        }

        int frameNumber = pageTable.get(pageNumber);
        return (frameNumber * pageSize) + offset;
    }

// error display handling and output
    private void handlePageFault(int pageNumber) {
        pageFaults++;
        if (pageQueue.size() == FRAME_COUNT) {
            int evictedPage = pageQueue.poll();
            System.out.println("Page Fault: Page " + Integer.toHexString(pageNumber) +
                               " loaded in frame " + framePointer +
                               " replaces page " + Integer.toHexString(evictedPage));
            pageTable.remove(evictedPage);
            loadedPages.remove(evictedPage);
        } else {
            System.out.println("Page Fault: Page " + Integer.toHexString(pageNumber) +
                               " loaded in frame " + framePointer);
        }

        pageQueue.add(pageNumber);
        pageTable.put(pageNumber, framePointer);
        loadedPages.add(pageNumber);
        framePointer = (framePointer + 1) % FRAME_COUNT;
    }

    public void printHitRatio() {
        double hitRatio = (double) hits / totalAccesses;
        System.out.println("Hit ratio: " + hitRatio);
    }
}

// main class , reads file and creates out file 
// try catch blocks to catch exceptions 
// file handling 
public class VirtualMemoryTranslator {
    public static void main(String[] args) {
        String inputFile = "virtual.txt";
        String outputFile = "physical.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            MemoryManager memoryManager = new MemoryManager();
            String line;

            while ((line = br.readLine()) != null) {
                int virtualAddress = Integer.parseInt(line, 16);
                int physicalAddress = memoryManager.translateAddress(virtualAddress);
                bw.write(String.format("%04X\n", physicalAddress));
            }

            memoryManager.printHitRatio();
            System.out.println("File " + outputFile + " closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
