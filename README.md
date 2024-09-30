# COMP4500/7500 Advanced Algorithms and Data Structures - Assignment 2

**School**: School of Electrical Engineering and Computer Science, The University of Queensland
**Semester**: 2, 2024
**Due Date**: 3pm, Friday 18th of October 2024

## 1. General Information
- This assignment is worth 20% (COMP4500) or 15% (COMP7500) of the final grade.
- It is to be attempted individually and aims to test understanding of dynamic programming.

## 2. Submission Guidelines
- **Written Answers**: Answers to written questions (Q1(b), Q1(d), Q1(e)) should be in a pdf file called `A2.pdf`.
- **Source Code**: `Recursive.java` and `Dynamic.java` should be submitted electronically via Blackboard according to the instructions on [https://learn.uq.edu.au/](https://learn.uq.edu.au/).
- Multiple submissions are allowed before the deadline, but only the last one will be saved and marked.
- Submitted work should be neat, legible, and simple to understand. Incorrect submissions will receive 0 marks.

## 3. Late Submission Policy
- A penalty of 10% of the maximum possible mark will be deducted per 24 hours for up to 7 days. After 7 days, a mark of 0 will be given.
- Medical or exceptional circumstances require an extension request via [https://my.uq.edu.au/](https://my.uq.edu.au/) with a maximum of 7 days from the original deadline.

## 4. School Policy on Student Misconduct
- Read and understand the School Statement on Misconduct available at [https://eecs.uq.edu.au/current-students/student-guidelines/student-conduct](https://eecs.uq.edu.au/current-students/student-guidelines/student-conduct). Plagiarism or collusion will result in penalties.

## 5. Assignment Problem
### 5.1 Problem Description
- You are in charge of a small microbrewery business for `k` consecutive days. You have a work schedule represented by an array `work` of `k` non-negative integers.
- There are two workers `w0` and `w1` with specific working constraints such as maximum number of consecutive days they can work (`maxShift`), minimum number of days off between shifts (`minBreak`), their capacity to complete work on each day (`capacity`), and salary cost for working on each day (`cost`).
- A roster for the `k` days is a list where each element indicates the set of workers scheduled to work on that day. A roster is valid if it satisfies the workers' constraints.
- The goal is to find a valid roster for the `k` days with the minimum total cost.

### 5.2 Example
- Consider `k = 5` days, `work = [15,5,12,17,7]`, `w0 = (maxShift = 2, minBreak = 1, capacity = [10,4,5,0,8], cost = [1,2,2,1,1])`, and `w1 = (maxShift = 1, minBreak = 3, capacity = [6,8,3,2,3], cost = [0,1,1,1,2])`.
- An optimal roster is `roster = [{"w0", "w1"},{},{"w0"},{},{"w0"}]` with a total cost of 33.

### 5.3 Tasks
1. **(a) Optimal Substructure - Recursive Solution (20 marks)**
   - Implement the `public static method optimalRecursive` in the `Recursive` class to provide a naive recursive algorithm to determine the total cost of an optimal valid roster. The method should not return the roster itself but only the total cost.
2. **(b) Time Complexity of Recursive Algorithm (15 marks)**
   - Give an asymptotic lower bound on the worst-case time complexity of the recursive algorithm in terms of `k`. Provide a lower-bound recurrence, justify it, and solve it.
3. **(c) Dynamic Programming Solution (30 marks)**
   - Implement the `public static method optimalDynamic` in the `Dynamic` class to develop an efficient bottom-up dynamic programming solution (not memoised) to find the total cost of an optimal valid roster.
4. **(d) Time Complexity of Dynamic Programming Solution (10 marks)**
   - Provide an asymptotic upper bound on the worst-case time complexity of the dynamic programming solution in terms of `k`.
5. **(e) Space Complexity of Dynamic Programming Solution (5 marks)**
   - Provide an asymptotic upper bound on the worst-case space complexity of the dynamic programming solution in terms of `k`.
6. **(f) Extended Dynamic Programming Solution (20 marks)**
   - Implement the `public static method optimalSolutionDynamic` in the `Dynamic` class to extend the bottom-up dynamic programming solution to calculate a valid roster with the least cost.

# COMP4500 Algorithms A2
# 加微信 powcoder

# QQ 1823890830

# Programming Help Add Wechat powcoder

# Email: powcoder@163.com

