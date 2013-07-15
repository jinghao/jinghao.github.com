---
layout: post
title: Incremental Web-Backup with Data Aggregation
created: 1221358095
categories: []
---
I searched for hours for an application that performs incremental backup to an online destination (say, SSH) and also uses data aggregation--uploading a single file containing all of the files that need to be backed up. Why did I want a backup utility with that exact design?

Because I learned through experience that most of the time in transferring average-sized files is spent in communicating the meta-data, file tree, and in waiting for responses from the destination servers (as you may know, it takes much longer to upload 1000 2 byte files than it takes to upload a single 10kb file). So how do we do it?
<h3>The Solution</h3>
The solution, which apparently nobody else has come up with, is to create and upload a single contiguous backup file, and can be broken into three parts. The following describes what the backup utility will do.
<h4>Part One: Backing up for the first time:</h4>
<ol>
	<li>create a tarchive of the backup into a file like backup.tar</li>
	<li>compile a small database (using SQLite is fine) that contains the file meta-data (including the last-modified fimes and the hashed file contents) and the file-tree</li>
	<li>upload them to the destination.</li>
</ol>
<h4>Part Two: Subsequent backups:</h4>
<ol>
	<li>query the database to determine
		<ol type="a">
			<li>what files need to be removed</li>
			<li>what files are new</li>
			<li>what files have been updated (using last-modified times and the hash codes)</li>
		</ol>
	</li>
	<li>update backup.tar by
		<ol type="a">
			<li>removing from backup.tar the files that need to be updated (server-side</li>
			<li>creating another tarchive containing the new and updated files (local)</li>
			<li>uploading that tarchive in one-megabyte increments, hash-checking for file integrity along the way (server-side)</li>
			<li>merging the one-megabyte files with backup.tar (server-side)</li>
		</ol>
	</li>
	<li>upload the updated database</li>
</ol>
<h4>Part Three: Restoring backups:</h4>
Download the tarchive and extract it, maintaining the meta-data (like permissions, ownership, last-modified time, etc).

Simple, quick, and not network-intensive. If merging zip files were fast enough, the utility can use that instead of tar, to further save on bandwidth and thus cut down on time. What do you think?
