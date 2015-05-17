---
layout: post
title: "Programming Competition"
tags: [programming, computer science, UC Berkeley]
---
In the spring semester of 2009 when I was a sophomore at Berkeley, I was taking the algorithms class taught by professor Dave Wagner. Most of the class is very theoretical. Problem sets and midterms focused on proofs and complexity analysis.

One day, the professor decided to hold a programming competition to see who can write the fastest program to solve some string problems. This would be one of the few times where you needed to program. There would also be a prize involved--his favorite book Programming Pearls, signed by him. It would be a good complement to the heavy focus on theory so far.

I chose to implement a simpler, but asymptotically worse algorithm. The consequences of not winning weren't high, but the consequences of a flawed implementation or algorithm were much greater. So this decision seemed natural.

The day came when the professor wrote the running times and implementation language of the top 10 submissions (250~ students) on the board (plus our account IDs which were random letters like `cs170-ab`). I was surprised to see my submission at the top.

It turns out that the professor used standard test inputs like The Bible and War and Peace, rather than adversarial inputs that tested the asymptic bound. The professor explained that the top few solutions were all using the simpler, but "worse" algorithm. The main difference between mine and the second submission is that I used the C language whereas the second submission was in Java.

The irony of the situation became apparent to many people. The whole semester up until that point, we've been focused on asymptotic time/complexity, yet the clever and hard-working folks who implemented better algorithms were not the ones to win. And among those who chose the simpler algorithm, it was the C implementation that won overall.

Further compounding the irony was the fact that I spent most of my time on the project optimizing my C code, from writing a custom sort function (saved around 20% time on The Bible) to optimizing compiler flags and compilers (Using g++ led to a 10% faster program--not sure why). At the end of the day, instead of focusing on implementing the "best" algorithm, I focused on all the things that are unmentioned in the algorithms class.

Of course, if the professor had wanted to use this project to teach us a lesson about complexity, he could've used more adversarial inputs to really test the algorithm. Perhaps he chose these test inputs to remind us that complexity isn't all that matters in real life.
