import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.net.*;

public class FreeRice {
	// change to true if you really want to check each request
	private static final boolean forceCheck = true;
	
	private static final int threads = 100;
	
	// our connection stuff
	private static Socket[] hostSocket = new Socket[threads]; // create the socket object
	private static PrintWriter[] out = new PrintWriter[threads]; // create the object we're printing to
	private static BufferedReader[] in = new BufferedReader[threads]; // create the object we're putting input in
	private static final String hostName = "www.freerice.com";
    	
	// Used to store the query that gets sent over and over again
	private static String queryString[] = new String[threads];
	
	// the two patterns to match
	private static final Pattern[] ricePatterns = {
			Pattern.compile("<input type=hidden name=\"INFO\" value=[0-9]+ />"),
			Pattern.compile("<input type=hidden name=\"INFO2\" value=[0-9]+ />"),
	};
	
	private static long grains = 0;
	private static long startTime; // Get current time
	
    public static void main(String[] args) throws Exception {
    	// String used to temporarily store POST return values
    	String serverOutput;
		
		// Universal matcher object for 
		Matcher formMatcher;
		
		// Init threads
		int threadID;
		
		System.out.println("Getting INFO & INFO2 for all threads...");
    	
		for(threadID = 0; threadID < threads; threadID++) {
			System.out.print("\t" + threadID + ". Initializing thread... ");
			
	    	// Send an empty request
			if(postQuery(threadID, "")) {
				// Try to get INFO and INFO2 to start off
				while ((serverOutput = getLine(threadID)) != null) {
					// INFO hasn't been retrieved yet
					if(queryString[threadID] == null) {
						formMatcher = ricePatterns[0].matcher(serverOutput);
					
						if(formMatcher.find())
							queryString[threadID] = "INFO="+formMatcher.group().replaceFirst("^.+=([0-9]+).+$", "$1")+"&";
						
					// Remember that INFO2 appears after INFO
					} else {
						formMatcher = ricePatterns[1].matcher(serverOutput);
					
						if(formMatcher.find())
							queryString[threadID] += "INFO2="+formMatcher.group().replaceFirst("^.+=([0-9]+).+$", "$1")+"&SELECTED=";
					
						// We have nothing to get after INFO2, so end this process
						System.out.println("done.");
						break;
					}
				}
				
				// Keep it clean
				closeLinks(threadID);
			}
		}
		
		System.out.println("Trying all four options...");
		
		// loop through all four SELECTED		
		for(threadID = 0; threadID < threads; threadID++) {
			System.out.println(threadID+". Trying all four options...");
			OPTIONS_LOOP: for(byte SELECTED = 1; SELECTED < 5; SELECTED++) {
				// grab the stream
				if(postQuery(threadID, queryString[threadID] + SELECTED)) {
					System.out.print("\tTrying option "+SELECTED+"... ");
				
					// keep getting data
					while ((serverOutput = getLine(threadID)) != null) {
						// Answer was incorrect (FIX ME: What if the word or a definition was "incorrect"?)
						if(serverOutput.indexOf("incorrect") != -1) {
							System.out.println("incorrect.");
							closeLinks(threadID);
							break; // Obviously this isn't the right answer, so skip to the next one
						}
					
						// Answer was correct
						if(serverOutput.indexOf("correctDef") != -1) {
							System.out.println("correct.");
							queryString[threadID] += SELECTED; // Concatenate the correct option into queryString
							closeLinks(threadID);
							break OPTIONS_LOOP;
						}
					}
				}
			}
		}

		boolean postStatus[] = new boolean[threads];
		startTime = System.currentTimeMillis();
		
		// Just keep submitting the same answer over and over again
		while(true) {
			System.out.println("Starting new cycle...");
			for(threadID = 0; threadID < threads; threadID++) {
				postStatus[threadID] = postQuery(threadID, queryString[threadID]);
			}
			
			for(threadID = 0; threadID < threads; threadID++) {
				if(postStatus[threadID]) {
					if(forceCheck) {
						while ((serverOutput = getLine(threadID)) != null) {
							if(serverOutput.indexOf("correctDef") != -1) {
								announceGrains(threadID);
								break;
							}
						}
					} else {
						announceGrains(threadID);
					}

					// Clean up after yourself!
					closeLinks(threadID);
				}
			}
		}
    }
    
    // Posts query onto freerice.com and returns an input stream of the return data
	private static boolean postQuery(int threadID, String query) throws IOException {		
		try {
			hostSocket[threadID] = new Socket(hostName, 80);
			out[threadID] = new PrintWriter(hostSocket[threadID].getOutputStream(), true);
			in[threadID] = new BufferedReader(new InputStreamReader(hostSocket[threadID].getInputStream()));
		} catch (ConnectException e) {
			announceError("Connection timed out.");
			return false;
		} catch (IOException e) {
			announceError("Couldn't get I/O for the connection.");
			return false;
		}

		// send header
		out[threadID].println("POST /index.php HTTP/1.1\r\n" +
					"Host: "+hostName+"\r\n"+
					"Content-length: " + query.length() + "\r\n"+
					"Content-Type: application/x-www-form-urlencoded\r\n");

		// send body
		out[threadID].println(query);
		
		return true;
	}
	
	private static String getLine(int threadID) throws IOException {
		try {
			return in[threadID].readLine();
		} catch (SocketException e) {
			announceError("Connection reset on thread "+threadID);
			return null;
		}
	}
	
	// Closes the connections
	private static void closeLinks(int threadID) throws IOException {
		out[threadID].close();
		in[threadID].close();
		hostSocket[threadID].close();
	}
	
	private static void announceError(String errorStr) throws IOException {
		System.out.println(errorStr);
	}
	
	private static void announceGrains(int threadID) throws IOException {
		// Add grain count
		grains += 20;
		
		long speed = (1000 * grains / (System.currentTimeMillis()-startTime));
		double bandwidth = (int)((queryString[threadID].length() + 125) / 2. * speed / 1024.) / 10.; // bytes POSTed per grain

		System.out.println("\t" + threadID + ". " + grains + " grains donated: "+ speed + "gps/" + bandwidth + "kbps.");
	}
}
