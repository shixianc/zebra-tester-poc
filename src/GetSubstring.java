// Some parts of this code have been automatically generated - copyright for generic plug-in procedure reserved by Ingenieurbuero David Fischer AG, Switzerland.
// Copyright for manual written code belongs to <your name>, <your company>, <your country>
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.LoadtestPluginInterface;
import dfischer.utils.LoadtestPluginFixedUserInputField;
import dfischer.utils.LogVector;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.PerformanceData;
import dfischer.utils.CookieHandler;
import dfischer.utils.HttpTestURL;

/**
 * Load test add-on module.
 */
public class GetSubstring implements LoadtestPluginInterface
{


	private LogVector logVector = null;		// internal log vector - use logVector.log(<String>) to write log data
  private String inputString = null;
  private String fromString = null;
  private String toString = null;


	// ----------------------------------------------------------------------------
	// PART 1: var handler GUI definition and load test integration
	//
	// Note: automatically generated - no manual programming required for this part
	// ----------------------------------------------------------------------------


	public int getPluginType()
	{
		return GenericPluginInterface.TYPE_LOADTEST_EXEC;
	}


	public String getPluginName()
	{
		return "GetSubstring";
	}


	public String getPluginDescription()
	{
		return "This class implemented for outputting string that is between two substrings user inputted.";
	}


	public int getAllowedConstructScope()
	{
		 return LoadtestPluginInterface.CONSTRUCT_SCOPE_NOT_FIXED;
	}


	public int getAllowedExecScope()
	{
		 return LoadtestPluginInterface.EXEC_SCOPE_NOT_FIXED;
	}


	public int getAllowedExecOrder()
	{
		 return LoadtestPluginInterface.EXEC_ORDER_BEFORE;
	}


	public boolean allowMultipleUsage()
	{
		return false;
	}


	public String[] getInputParameterLabels()
	{
		String[] labels = new String[3];
    labels[0] = "Input_String";
    labels[1] = "From_String";
    labels[2]= "To_String";
		return labels;
	}


	public LoadtestPluginFixedUserInputField[] getFixedUserInputFields()
	{
		return null;
	}

	public int allowOptionalInputParameter()
	{
		return -1;		// all input parameters required
	}


	public String[] getOutputParameterLabels()
	{
		String[] labels = new String[0];
		return labels;
	}


	public int allowOptionalOutputParameter()
	{
		return -1;		// all output parameters required
	}


	public LogVector getLogVector()
	{
		return logVector;
	}



	// ----------------------------------------------------------------------------
	// PART 2: runtime behavior / plug-in functionality
	//
	// This part requires manual programming (see sample code section below)
	// ----------------------------------------------------------------------------


	/**
	 * Initialize plug-in .
	 */
	public void construct(Object context)
	{
	   // LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
	}


	/**
	 * Transfer input parameter before execute() is called.
	 */
	public void setInputParameter(int parameterNumber, Object parameterValue)
	{
		switch (parameterNumber)
		{
      case 0:
              this.inputString = (String) parameterValue;
              break;
      case 1:
              this.fromString = (String) parameterValue;
              break;
      case 2:
              this.toString = (String) parameterValue;
              break;
			default:
				      break;
		}
	}


	/**
	 * Execute plug-in .
	 *
	 * Intrinsic plug-in implementation.
	 */
	public void execute(Object context)
	{
		logVector = new LogVector();
		// LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
    //
		// // vvv --- sample code --- vvv
    //
		// PerformanceData performanceData = pluginContext.getPerformanceData();
		// long passedLoops = performanceData.getPassedLoops();
		// long failedLoops = performanceData.getFailedLoops();
    //
		// int scope = pluginContext.getContextScope();
    String result = getSubString(inputString, fromString, toString);
    System.out.println(result);

		if (false)		// internal error ?
			throw new RuntimeException("internal error in plug-in occured");

		// ^^^ --- sample code --- ^^^
	}


	/**
	 * Return plug-in output parameter.
	 */
	public Object getOutputParameter(int parameterNumber)
	{
		switch (parameterNumber)
		{
			default:
				return null;
		}
	}


	/**
	 * Finalize plug-in .
	 */
	public void deconstruct(Object context)
	{
		// LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
	}

  /**
    * this method output the substring between "fromString" and "toString" exclusively.
    * PRE: assume there exists at most 1 pair of [from, toString] for the answer
    *
    * @param inputString string for input
    * @param fromString  left bound of the substring
    * @param toString    right bound of the substring
    * @return the substring between fromString and toString exclusively.
    */
   public String getSubString(String inputString, String fromString, String toString) {
       //corner cases
       if (inputString == null || fromString == null || toString == null) {
           return "[ERROR] Invalid Null Input.";
       } else if (inputString.length() == 0 || fromString.length() == 0 || toString.length() == 0) {
           return "[ERROR] Invalid Null Input.";
       } else if (inputString.length() < fromString.length() || inputString.length() < toString.length()) {
           return "[ERROR] Invalid Null Input.";
       }

       //assume there is at most 1 pair of [fromString, toString] can be found in input.
       int fromIndex = -1;
       int toIndex = -1;
       for (int i = 0; i < inputString.length(); i++) {
           char curr = inputString.charAt(i);
           if (curr == fromString.charAt(0) && check(inputString, fromString, i)) {
               fromIndex = i;
           } else if (curr == toString.charAt(0) && check(inputString, toString, i)) {
               toIndex = i;
               if (fromIndex != -1) {
                   break;
               }
           }
       }
       if (toIndex != -1 && fromIndex != -1) {
           //corner cases: Overlapping or wrong sequence
           if (fromIndex + fromString.length() > toIndex) {
               return "[ No Matching Found! ]";
           } else {
               return inputString.substring(fromIndex + fromString.length(), toIndex);
           }
       } else {
           return "[ No Matching Found! ]";
       }
   }

   /**
    * this method helps to checking if the matches found starting from index "begin".
    *
    * @param inputString user input string
    * @param target      string for matching
    * @param begin       index for begin checking
    * @return true for match, false for none match
    */
   private boolean check(String inputString, String target, int begin) {
       for (int i = 0; i < target.length(); i++) {
           if (inputString.charAt(i + begin) != target.charAt(i)) {
               return false;
           }
       }
       return true;
   }

	// ----------------------------------------------------------------------------
	// PART 3: stand-alone test utility - optional - used for plug-in development
	// ----------------------------------------------------------------------------

	/*
	public static void main(String[] args)
	{
		try
		{
			// vvv --- sample code --- vvv

			test plugin = new test();
			plugin.construct(null);
			plugin.setInputParameter(0, args[0]);
			plugin.execute(null);
			System.sb.append(plugin.getOutputParameter(0));
			plugin.deconstruct(null);

			// ^^^ --- sample code --- ^^^
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	*/


}	// end of class
