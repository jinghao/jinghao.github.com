---
layout: post
title: Solid State Drives--The Solution in the Meantime
created: 1249183538
tags: technology hardware
---
The main impediment to the mainstream adoption of sold state drives is that affordability is not matched by capacity and performance. Simply put: Affordable drives lack random-write performance, and high-performance drives are expensive.

As is the nature of the microchip industry, cost will fall exponentially as capacity expands exponentially, so in a few years, neither will not be a major concern. But the disappointing [random-write performance](http://www.anandtech.com/storage/showdoc.aspx?i=3531&p=1) is a limitation that affects all consumer-oriented drives (the affordable ones). Random and sequential reads are superb, sequential writes are also worth the money, but random writes of 4kBs of data--the type that constitute a majority of write action--are unacceptably slow (a fifth to half a second), and this does stick out.

A driver update lets you sacrifice random read performance for random-write performance, and this does cause the latter to be unobtrusive, but not superb. Is that the limit of technology for those of us with non-enterprise budgets?

I don't think so. I don't dispute that 64 GB flash memory with high random-write performance is not affordable, but a 256 MB-1 GB high-performance cache definitely is.

Why not attach one of those to a SSD? All operations are done through the cache, which will function in an [LRU manner](http://en.wikipedia.org/wiki/Cache_algorithms#Least_Recently_Used). The difference is that writes will function asynchronously. As with caching schemes in general, this doesn't increase throughput, but this does definitely improve latency. Instead of taking a quarter second to write a 4 KB file, now all writes will appear instantaneous--as long as you are not writing separate 4 KB files continuously.

This will add an additional 2-5 dollars to the cost of your drive but improve perceived performance significantly. Caching has been used to allow CPU clock speed to increase exponentially while memory speed essentially remained stagnated. It can also allow affordable SSDs to perform as desired.

<h2>Hard Disk for Primary Storage</h2>

Using a magnetic hard disk for primary storage instead of a SSD is an even more immediate solution that's been explored by some manufacturers. The primary benefit is the availability of high-capacity devices at affordable price points. The reason I advocate a flash-based primary storage is the same as for a pure-flash solution: A combination of 1. no moving parts, 2. high durability, 3. greater performance, 4. energy efficiency and 5. physics.

As magnetic disk densities are approaching physical limits (before the magnetic fields interfere with each other), further improvements must come from the same avenue as microchip manufacturing, guided by Moore's law. Since data is stored as electric signals (rather than magnetic), flash has more room to improve further.

In other words, the reason I advocated flash over magnetic disks is that flash is the future. Don't avoid it.

Embrace the future.
