---
author:
- 'Brian C. Ladd'
date: Spring 2019
email: 'laddbc@potsdam.edu'
startup: showeverything
subtitle: CIS 443 Programming Languages
title: 'Count the Symbols **Outside** of Comments'
---

Overview
========

Students will modify their symbol counter (from the *countTheWords*
assignment) so that it only counts words **outside** of comments;
comments are as defined in the *sansCommentFilter* assignment. Students
are required to use the `SansCommentFilter` from the first assignment to
extend their word counter.

User Interface
==============

The user interface for the `WordCounter` program **remains the same**.
----------------------------------------------------------------------

### See the *countTheWords* assignment if you have questions.

The processing of an input file changes:
----------------------------------------

### This version of the word counter is **comment aware**.

### No words should be counted within any comment.

Deliverables/Submission Method
==============================

Submission is using Git version control and cs-devel.
-----------------------------------------------------

Don't forget `.gitignore`.
--------------------------

The project is to be a Gradle project that can be built and run within the tool.
--------------------------------------------------------------------------------

The project must include a `README` file explaining the problem, the solution, and how it is run.
-------------------------------------------------------------------------------------------------

### You must document how you **tested** your program. Input, expected output, what the test proves when it passes.
