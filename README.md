# java_project
This project is part of the  parallel programming coursework. The main objective is to implement a thread-safe system that computes the maximum integer in a large LinkedList using parallel processing. This task emphasizes understanding multithreading, thread safety, synchronization, and scalable parallel design patterns in Java.
🔍 Problem Statement
Given a LinkedList<Integer> of size 10,000,000, the goal is to compute the maximum integer value using a two-stage parallel reduction strategy.
1.	Stage 1 - Fine-grained Parallelism:
o	Use 2,000 worker threads (ParallelMaximizerWorker) to compute local maxima from partitions of the main list.
o	Each worker safely removes elements from the list and calculates its own partial maximum.
o	All partial results are collected into a secondary list (list2).
2.	Stage 2 - Coarse-grained Parallelism:
o	Use 100 new worker threads to compute local maxima from list2.
o	The final maximum is calculated sequentially from the results of these 100 workers.
🧵 Thread Safety
•	All worker threads must synchronize access to the shared list to avoid race conditions.
•	Each thread is responsible for its own portion of work; no thread should idle or handle the entire computation alone.
•	Proper use of Java's synchronization mechanisms ensures thread-safe access and updates.
📂 Structure
•	ParallelMaximizer.java: Main logic for parallel maximum computation, manages workers and two-stage reduction.
•	ParallelMaximizerWorker.java: Runnable class responsible for computing local maximum in a thread-safe way.
•	PublicTest.java: Provided public test cases to verify correctness and behavior of the implementation.
✅ Deliverables
•	Modified and completed ParallelMaximizer and ParallelMaximizerWorker classes.
•	Ant build script (build.xml).
•	Packaged .zip submission including all source code, organized under a package named after the student's last name
