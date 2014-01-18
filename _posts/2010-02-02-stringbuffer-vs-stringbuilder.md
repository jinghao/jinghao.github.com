---
layout: post
title: StringBuffer vs. StringBuilder
created: 1265181549
categories: software programming java
---
I'm doing some research work that involves heavy work with the Java string classes (I have IBM Java), and I was trying to determine concretely (besides synchronization and such) the differences between StringBuffer and StringBuilder. I replaced "StringBuffer" with "StringBuilder" in <code>StringBuffer.java</code> and then <code>diff</code>ed them. The subsequent confusion led to an interesting discovery.

Before I go there, here's a brief summary for those of you with modest Java experience: StringBuilder is similar to StringBuffer in that it can be used to dynamically build strings of indeterminate length. The main difference is that StringBuilder, which came later (Java 1.5), is not synchronized (meaning that multiple threads could cause objects to act unexpectedly--a risk that pays for some level of performance), unlike StringBuffer. But since I was dealing with them at the code level, I needed to know more deeply where they differ.

Back to the topic: Check out the following excerpts from <strong>StringBuilder.java</strong>:

The constructor:

    /**
     * Constructs a <strong>new StringBuffer</strong> using the default capacity.
     */
    public <strong>StringBuilder</strong>() {
    	this(INITIAL_SIZE);
    }

A normal method copied from StringBuffer:

    /**
     * Optionally modify the underlying char array to only
     * be large enough to hold the characters in <strong>this StringBuffer</strong>.
     */
    public void trimToSize() {
    	if (!shared && value.length != count) {
    		char[] newValue = new char[count];
    		System.arraycopy(value, 0, newValue, 0, count);
    		value = newValue;
    	}
    }

Another method copied directly from StringBuffer:

    /**
     * Adds the specified code point to the end of <strong>this StringBuffer</strong>.
     *
     * @param		codePoint	the code point
     * @return		<strong>this StringBuffer</strong>
     */
    public <strong>StringBuilder</strong> appendCodePoint(int codePoint) {
    	if (codePoint >= 0) {
    		if (codePoint < 0x10000) {
    			return append((char)codePoint);
    		} else if (codePoint < 0x110000) {
    			if (count + 2 > value.length) {
    				ensureCapacityImpl(count + 2);
    			}
    			codePoint -= 0x10000;
    			value[count] = (char)(0xd800 + (codePoint >> 10));
    			value[count+1] = (char)(0xdc00 + (codePoint & 0x3ff));
    			count += 2;
    			return this;
    		}
    	}
    	throw new IllegalArgumentException();
    }

If it's not apparent yet, what's clear is that the authors of IBM Java 5 copied-and-pasted StringBuffer into StringBuilder--word for word, including comments--and changed some variable names until the red underlines (from syntax errors) disappeared, and forgot about the comments.

Interesting discovery. I'm not sure what the lesson here is. I suppose enterprise developers are also lazy and forgetful.
