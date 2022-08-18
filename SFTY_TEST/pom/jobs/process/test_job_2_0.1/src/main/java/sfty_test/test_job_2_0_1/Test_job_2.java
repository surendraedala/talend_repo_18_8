
package sfty_test.test_job_2_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: Test_job_2 Purpose: <br>
 * Description:  <br>
 * @author Edala, Surendra
 * @version 8.0.1.20220729_0744-patch
 * @status 
 */
public class Test_job_2 implements TalendJob {
	static {System.setProperty("TalendJob.log", "Test_job_2.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Test_job_2.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Test_job_2";
	private final String projectName = "SFTY_TEST";
	public Integer errorCode = null;
	private String currentComponent = "";
	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_Q1lEIB4aEe2Yt8Pd1zyX2A", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	
	private String currentComponent = null;
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Test_job_2.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Test_job_2.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
			talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
			talendJobLogProcess(globalMap);
		}
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	



public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_SFTY_TEST_Test_job_2 = new byte[0];
    static byte[] commonByteArray_SFTY_TEST_Test_job_2 = new byte[0];

	
			    public Long serial_id;

				public Long getSerial_id () {
					return this.serial_id;
				}

				public Boolean serial_idIsNullable(){
				    return true;
				}
				public Boolean serial_idIsKey(){
				    return false;
				}
				public Integer serial_idLength(){
				    return 19;
				}
				public Integer serial_idPrecision(){
				    return 0;
				}
				public String serial_idDefault(){
				
					return null;
				
				}
				public String serial_idComment(){
				
				    return "";
				
				}
				public String serial_idPattern(){
				
					return "";
				
				}
				public String serial_idOriginalDbColumnName(){
				
					return "serial_id";
				
				}

				
			    public String S_CITY;

				public String getS_CITY () {
					return this.S_CITY;
				}

				public Boolean S_CITYIsNullable(){
				    return true;
				}
				public Boolean S_CITYIsKey(){
				    return false;
				}
				public Integer S_CITYLength(){
				    return 2147483647;
				}
				public Integer S_CITYPrecision(){
				    return 0;
				}
				public String S_CITYDefault(){
				
					return null;
				
				}
				public String S_CITYComment(){
				
				    return "";
				
				}
				public String S_CITYPattern(){
				
					return "";
				
				}
				public String S_CITYOriginalDbColumnName(){
				
					return "S_CITY";
				
				}

				
			    public String E_CITY;

				public String getE_CITY () {
					return this.E_CITY;
				}

				public Boolean E_CITYIsNullable(){
				    return true;
				}
				public Boolean E_CITYIsKey(){
				    return false;
				}
				public Integer E_CITYLength(){
				    return 2147483647;
				}
				public Integer E_CITYPrecision(){
				    return 0;
				}
				public String E_CITYDefault(){
				
					return null;
				
				}
				public String E_CITYComment(){
				
				    return "";
				
				}
				public String E_CITYPattern(){
				
					return "";
				
				}
				public String E_CITYOriginalDbColumnName(){
				
					return "E_CITY";
				
				}

				
			    public String VACATION;

				public String getVACATION () {
					return this.VACATION;
				}

				public Boolean VACATIONIsNullable(){
				    return true;
				}
				public Boolean VACATIONIsKey(){
				    return false;
				}
				public Integer VACATIONLength(){
				    return 2147483647;
				}
				public Integer VACATIONPrecision(){
				    return 0;
				}
				public String VACATIONDefault(){
				
					return null;
				
				}
				public String VACATIONComment(){
				
				    return "";
				
				}
				public String VACATIONPattern(){
				
					return "";
				
				}
				public String VACATIONOriginalDbColumnName(){
				
					return "VACATION";
				
				}

				
			    public Long DISTANCE;

				public Long getDISTANCE () {
					return this.DISTANCE;
				}

				public Boolean DISTANCEIsNullable(){
				    return true;
				}
				public Boolean DISTANCEIsKey(){
				    return false;
				}
				public Integer DISTANCELength(){
				    return 19;
				}
				public Integer DISTANCEPrecision(){
				    return 0;
				}
				public String DISTANCEDefault(){
				
					return null;
				
				}
				public String DISTANCEComment(){
				
				    return "";
				
				}
				public String DISTANCEPattern(){
				
					return "";
				
				}
				public String DISTANCEOriginalDbColumnName(){
				
					return "DISTANCE";
				
				}

				
			    public Double FARE;

				public Double getFARE () {
					return this.FARE;
				}

				public Boolean FAREIsNullable(){
				    return true;
				}
				public Boolean FAREIsKey(){
				    return false;
				}
				public Integer FARELength(){
				    return 17;
				}
				public Integer FAREPrecision(){
				    return 17;
				}
				public String FAREDefault(){
				
					return null;
				
				}
				public String FAREComment(){
				
				    return "";
				
				}
				public String FAREPattern(){
				
					return "";
				
				}
				public String FAREOriginalDbColumnName(){
				
					return "FARE";
				
				}

				
			    public Long S_INCOME;

				public Long getS_INCOME () {
					return this.S_INCOME;
				}

				public Boolean S_INCOMEIsNullable(){
				    return true;
				}
				public Boolean S_INCOMEIsKey(){
				    return false;
				}
				public Integer S_INCOMELength(){
				    return 19;
				}
				public Integer S_INCOMEPrecision(){
				    return 0;
				}
				public String S_INCOMEDefault(){
				
					return null;
				
				}
				public String S_INCOMEComment(){
				
				    return "";
				
				}
				public String S_INCOMEPattern(){
				
					return "";
				
				}
				public String S_INCOMEOriginalDbColumnName(){
				
					return "S_INCOME";
				
				}

				
			    public Long E_INCOME;

				public Long getE_INCOME () {
					return this.E_INCOME;
				}

				public Boolean E_INCOMEIsNullable(){
				    return true;
				}
				public Boolean E_INCOMEIsKey(){
				    return false;
				}
				public Integer E_INCOMELength(){
				    return 19;
				}
				public Integer E_INCOMEPrecision(){
				    return 0;
				}
				public String E_INCOMEDefault(){
				
					return null;
				
				}
				public String E_INCOMEComment(){
				
				    return "";
				
				}
				public String E_INCOMEPattern(){
				
					return "";
				
				}
				public String E_INCOMEOriginalDbColumnName(){
				
					return "E_INCOME";
				
				}

				
			    public Long S_POP;

				public Long getS_POP () {
					return this.S_POP;
				}

				public Boolean S_POPIsNullable(){
				    return true;
				}
				public Boolean S_POPIsKey(){
				    return false;
				}
				public Integer S_POPLength(){
				    return 19;
				}
				public Integer S_POPPrecision(){
				    return 0;
				}
				public String S_POPDefault(){
				
					return null;
				
				}
				public String S_POPComment(){
				
				    return "";
				
				}
				public String S_POPPattern(){
				
					return "";
				
				}
				public String S_POPOriginalDbColumnName(){
				
					return "S_POP";
				
				}

				
			    public Long E_POP;

				public Long getE_POP () {
					return this.E_POP;
				}

				public Boolean E_POPIsNullable(){
				    return true;
				}
				public Boolean E_POPIsKey(){
				    return false;
				}
				public Integer E_POPLength(){
				    return 19;
				}
				public Integer E_POPPrecision(){
				    return 0;
				}
				public String E_POPDefault(){
				
					return null;
				
				}
				public String E_POPComment(){
				
				    return "";
				
				}
				public String E_POPPattern(){
				
					return "";
				
				}
				public String E_POPOriginalDbColumnName(){
				
					return "E_POP";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SFTY_TEST_Test_job_2.length) {
				if(length < 1024 && commonByteArray_SFTY_TEST_Test_job_2.length == 0) {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[1024];
				} else {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SFTY_TEST_Test_job_2, 0, length);
			strReturn = new String(commonByteArray_SFTY_TEST_Test_job_2, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SFTY_TEST_Test_job_2.length) {
				if(length < 1024 && commonByteArray_SFTY_TEST_Test_job_2.length == 0) {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[1024];
				} else {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SFTY_TEST_Test_job_2, 0, length);
			strReturn = new String(commonByteArray_SFTY_TEST_Test_job_2, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
					this.S_CITY = readString(dis);
					
					this.E_CITY = readString(dis);
					
					this.VACATION = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DISTANCE = null;
           				} else {
           			    	this.DISTANCE = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.FARE = null;
           				} else {
           			    	this.FARE = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.S_INCOME = null;
           				} else {
           			    	this.S_INCOME = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.E_INCOME = null;
           				} else {
           			    	this.E_INCOME = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.S_POP = null;
           				} else {
           			    	this.S_POP = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.E_POP = null;
           				} else {
           			    	this.E_POP = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
					this.S_CITY = readString(dis);
					
					this.E_CITY = readString(dis);
					
					this.VACATION = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DISTANCE = null;
           				} else {
           			    	this.DISTANCE = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.FARE = null;
           				} else {
           			    	this.FARE = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.S_INCOME = null;
           				} else {
           			    	this.S_INCOME = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.E_INCOME = null;
           				} else {
           			    	this.E_INCOME = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.S_POP = null;
           				} else {
           			    	this.S_POP = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.E_POP = null;
           				} else {
           			    	this.E_POP = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
					// String
				
						writeString(this.S_CITY,dos);
					
					// String
				
						writeString(this.E_CITY,dos);
					
					// String
				
						writeString(this.VACATION,dos);
					
					// Long
				
						if(this.DISTANCE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.DISTANCE);
		            	}
					
					// Double
				
						if(this.FARE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.FARE);
		            	}
					
					// Long
				
						if(this.S_INCOME == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.S_INCOME);
		            	}
					
					// Long
				
						if(this.E_INCOME == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.E_INCOME);
		            	}
					
					// Long
				
						if(this.S_POP == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.S_POP);
		            	}
					
					// Long
				
						if(this.E_POP == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.E_POP);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
					// String
				
						writeString(this.S_CITY,dos);
					
					// String
				
						writeString(this.E_CITY,dos);
					
					// String
				
						writeString(this.VACATION,dos);
					
					// Long
				
						if(this.DISTANCE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.DISTANCE);
		            	}
					
					// Double
				
						if(this.FARE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.FARE);
		            	}
					
					// Long
				
						if(this.S_INCOME == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.S_INCOME);
		            	}
					
					// Long
				
						if(this.E_INCOME == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.E_INCOME);
		            	}
					
					// Long
				
						if(this.S_POP == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.S_POP);
		            	}
					
					// Long
				
						if(this.E_POP == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.E_POP);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("serial_id="+String.valueOf(serial_id));
		sb.append(",S_CITY="+S_CITY);
		sb.append(",E_CITY="+E_CITY);
		sb.append(",VACATION="+VACATION);
		sb.append(",DISTANCE="+String.valueOf(DISTANCE));
		sb.append(",FARE="+String.valueOf(FARE));
		sb.append(",S_INCOME="+String.valueOf(S_INCOME));
		sb.append(",E_INCOME="+String.valueOf(E_INCOME));
		sb.append(",S_POP="+String.valueOf(S_POP));
		sb.append(",E_POP="+String.valueOf(E_POP));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(serial_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(serial_id);
            			}
            		
        			sb.append("|");
        		
        				if(S_CITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_CITY);
            			}
            		
        			sb.append("|");
        		
        				if(E_CITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_CITY);
            			}
            		
        			sb.append("|");
        		
        				if(VACATION == null){
        					sb.append("<null>");
        				}else{
            				sb.append(VACATION);
            			}
            		
        			sb.append("|");
        		
        				if(DISTANCE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DISTANCE);
            			}
            		
        			sb.append("|");
        		
        				if(FARE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(FARE);
            			}
            		
        			sb.append("|");
        		
        				if(S_INCOME == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_INCOME);
            			}
            		
        			sb.append("|");
        		
        				if(E_INCOME == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_INCOME);
            			}
            		
        			sb.append("|");
        		
        				if(S_POP == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_POP);
            			}
            		
        			sb.append("|");
        		
        				if(E_POP == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_POP);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_SFTY_TEST_Test_job_2 = new byte[0];
    static byte[] commonByteArray_SFTY_TEST_Test_job_2 = new byte[0];

	
			    public Long serial_id;

				public Long getSerial_id () {
					return this.serial_id;
				}

				public Boolean serial_idIsNullable(){
				    return true;
				}
				public Boolean serial_idIsKey(){
				    return false;
				}
				public Integer serial_idLength(){
				    return 19;
				}
				public Integer serial_idPrecision(){
				    return 0;
				}
				public String serial_idDefault(){
				
					return null;
				
				}
				public String serial_idComment(){
				
				    return "";
				
				}
				public String serial_idPattern(){
				
					return "";
				
				}
				public String serial_idOriginalDbColumnName(){
				
					return "serial_id";
				
				}

				
			    public String S_CITY;

				public String getS_CITY () {
					return this.S_CITY;
				}

				public Boolean S_CITYIsNullable(){
				    return true;
				}
				public Boolean S_CITYIsKey(){
				    return false;
				}
				public Integer S_CITYLength(){
				    return 2147483647;
				}
				public Integer S_CITYPrecision(){
				    return 0;
				}
				public String S_CITYDefault(){
				
					return null;
				
				}
				public String S_CITYComment(){
				
				    return "";
				
				}
				public String S_CITYPattern(){
				
					return "";
				
				}
				public String S_CITYOriginalDbColumnName(){
				
					return "S_CITY";
				
				}

				
			    public String E_CITY;

				public String getE_CITY () {
					return this.E_CITY;
				}

				public Boolean E_CITYIsNullable(){
				    return true;
				}
				public Boolean E_CITYIsKey(){
				    return false;
				}
				public Integer E_CITYLength(){
				    return 2147483647;
				}
				public Integer E_CITYPrecision(){
				    return 0;
				}
				public String E_CITYDefault(){
				
					return null;
				
				}
				public String E_CITYComment(){
				
				    return "";
				
				}
				public String E_CITYPattern(){
				
					return "";
				
				}
				public String E_CITYOriginalDbColumnName(){
				
					return "E_CITY";
				
				}

				
			    public String VACATION;

				public String getVACATION () {
					return this.VACATION;
				}

				public Boolean VACATIONIsNullable(){
				    return true;
				}
				public Boolean VACATIONIsKey(){
				    return false;
				}
				public Integer VACATIONLength(){
				    return 2147483647;
				}
				public Integer VACATIONPrecision(){
				    return 0;
				}
				public String VACATIONDefault(){
				
					return null;
				
				}
				public String VACATIONComment(){
				
				    return "";
				
				}
				public String VACATIONPattern(){
				
					return "";
				
				}
				public String VACATIONOriginalDbColumnName(){
				
					return "VACATION";
				
				}

				
			    public Long DISTANCE;

				public Long getDISTANCE () {
					return this.DISTANCE;
				}

				public Boolean DISTANCEIsNullable(){
				    return true;
				}
				public Boolean DISTANCEIsKey(){
				    return false;
				}
				public Integer DISTANCELength(){
				    return 19;
				}
				public Integer DISTANCEPrecision(){
				    return 0;
				}
				public String DISTANCEDefault(){
				
					return null;
				
				}
				public String DISTANCEComment(){
				
				    return "";
				
				}
				public String DISTANCEPattern(){
				
					return "";
				
				}
				public String DISTANCEOriginalDbColumnName(){
				
					return "DISTANCE";
				
				}

				
			    public Double FARE;

				public Double getFARE () {
					return this.FARE;
				}

				public Boolean FAREIsNullable(){
				    return true;
				}
				public Boolean FAREIsKey(){
				    return false;
				}
				public Integer FARELength(){
				    return 17;
				}
				public Integer FAREPrecision(){
				    return 17;
				}
				public String FAREDefault(){
				
					return null;
				
				}
				public String FAREComment(){
				
				    return "";
				
				}
				public String FAREPattern(){
				
					return "";
				
				}
				public String FAREOriginalDbColumnName(){
				
					return "FARE";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SFTY_TEST_Test_job_2.length) {
				if(length < 1024 && commonByteArray_SFTY_TEST_Test_job_2.length == 0) {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[1024];
				} else {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SFTY_TEST_Test_job_2, 0, length);
			strReturn = new String(commonByteArray_SFTY_TEST_Test_job_2, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SFTY_TEST_Test_job_2.length) {
				if(length < 1024 && commonByteArray_SFTY_TEST_Test_job_2.length == 0) {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[1024];
				} else {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SFTY_TEST_Test_job_2, 0, length);
			strReturn = new String(commonByteArray_SFTY_TEST_Test_job_2, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
					this.S_CITY = readString(dis);
					
					this.E_CITY = readString(dis);
					
					this.VACATION = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DISTANCE = null;
           				} else {
           			    	this.DISTANCE = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.FARE = null;
           				} else {
           			    	this.FARE = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
					this.S_CITY = readString(dis);
					
					this.E_CITY = readString(dis);
					
					this.VACATION = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DISTANCE = null;
           				} else {
           			    	this.DISTANCE = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.FARE = null;
           				} else {
           			    	this.FARE = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
					// String
				
						writeString(this.S_CITY,dos);
					
					// String
				
						writeString(this.E_CITY,dos);
					
					// String
				
						writeString(this.VACATION,dos);
					
					// Long
				
						if(this.DISTANCE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.DISTANCE);
		            	}
					
					// Double
				
						if(this.FARE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.FARE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
					// String
				
						writeString(this.S_CITY,dos);
					
					// String
				
						writeString(this.E_CITY,dos);
					
					// String
				
						writeString(this.VACATION,dos);
					
					// Long
				
						if(this.DISTANCE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.DISTANCE);
		            	}
					
					// Double
				
						if(this.FARE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.FARE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("serial_id="+String.valueOf(serial_id));
		sb.append(",S_CITY="+S_CITY);
		sb.append(",E_CITY="+E_CITY);
		sb.append(",VACATION="+VACATION);
		sb.append(",DISTANCE="+String.valueOf(DISTANCE));
		sb.append(",FARE="+String.valueOf(FARE));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(serial_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(serial_id);
            			}
            		
        			sb.append("|");
        		
        				if(S_CITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_CITY);
            			}
            		
        			sb.append("|");
        		
        				if(E_CITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_CITY);
            			}
            		
        			sb.append("|");
        		
        				if(VACATION == null){
        					sb.append("<null>");
        				}else{
            				sb.append(VACATION);
            			}
            		
        			sb.append("|");
        		
        				if(DISTANCE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DISTANCE);
            			}
            		
        			sb.append("|");
        		
        				if(FARE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(FARE);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_SFTY_TEST_Test_job_2 = new byte[0];
    static byte[] commonByteArray_SFTY_TEST_Test_job_2 = new byte[0];

	
			    public Long serial_id;

				public Long getSerial_id () {
					return this.serial_id;
				}

				public Boolean serial_idIsNullable(){
				    return true;
				}
				public Boolean serial_idIsKey(){
				    return false;
				}
				public Integer serial_idLength(){
				    return 19;
				}
				public Integer serial_idPrecision(){
				    return 0;
				}
				public String serial_idDefault(){
				
					return null;
				
				}
				public String serial_idComment(){
				
				    return "";
				
				}
				public String serial_idPattern(){
				
					return "";
				
				}
				public String serial_idOriginalDbColumnName(){
				
					return "serial_id";
				
				}

				
			    public String S_CITY;

				public String getS_CITY () {
					return this.S_CITY;
				}

				public Boolean S_CITYIsNullable(){
				    return true;
				}
				public Boolean S_CITYIsKey(){
				    return false;
				}
				public Integer S_CITYLength(){
				    return 2147483647;
				}
				public Integer S_CITYPrecision(){
				    return 0;
				}
				public String S_CITYDefault(){
				
					return null;
				
				}
				public String S_CITYComment(){
				
				    return "";
				
				}
				public String S_CITYPattern(){
				
					return "";
				
				}
				public String S_CITYOriginalDbColumnName(){
				
					return "S_CITY";
				
				}

				
			    public String E_CITY;

				public String getE_CITY () {
					return this.E_CITY;
				}

				public Boolean E_CITYIsNullable(){
				    return true;
				}
				public Boolean E_CITYIsKey(){
				    return false;
				}
				public Integer E_CITYLength(){
				    return 2147483647;
				}
				public Integer E_CITYPrecision(){
				    return 0;
				}
				public String E_CITYDefault(){
				
					return null;
				
				}
				public String E_CITYComment(){
				
				    return "";
				
				}
				public String E_CITYPattern(){
				
					return "";
				
				}
				public String E_CITYOriginalDbColumnName(){
				
					return "E_CITY";
				
				}

				
			    public String VACATION;

				public String getVACATION () {
					return this.VACATION;
				}

				public Boolean VACATIONIsNullable(){
				    return true;
				}
				public Boolean VACATIONIsKey(){
				    return false;
				}
				public Integer VACATIONLength(){
				    return 2147483647;
				}
				public Integer VACATIONPrecision(){
				    return 0;
				}
				public String VACATIONDefault(){
				
					return null;
				
				}
				public String VACATIONComment(){
				
				    return "";
				
				}
				public String VACATIONPattern(){
				
					return "";
				
				}
				public String VACATIONOriginalDbColumnName(){
				
					return "VACATION";
				
				}

				
			    public Long DISTANCE;

				public Long getDISTANCE () {
					return this.DISTANCE;
				}

				public Boolean DISTANCEIsNullable(){
				    return true;
				}
				public Boolean DISTANCEIsKey(){
				    return false;
				}
				public Integer DISTANCELength(){
				    return 19;
				}
				public Integer DISTANCEPrecision(){
				    return 0;
				}
				public String DISTANCEDefault(){
				
					return null;
				
				}
				public String DISTANCEComment(){
				
				    return "";
				
				}
				public String DISTANCEPattern(){
				
					return "";
				
				}
				public String DISTANCEOriginalDbColumnName(){
				
					return "DISTANCE";
				
				}

				
			    public Double FARE;

				public Double getFARE () {
					return this.FARE;
				}

				public Boolean FAREIsNullable(){
				    return true;
				}
				public Boolean FAREIsKey(){
				    return false;
				}
				public Integer FARELength(){
				    return 17;
				}
				public Integer FAREPrecision(){
				    return 17;
				}
				public String FAREDefault(){
				
					return null;
				
				}
				public String FAREComment(){
				
				    return "";
				
				}
				public String FAREPattern(){
				
					return "";
				
				}
				public String FAREOriginalDbColumnName(){
				
					return "FARE";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SFTY_TEST_Test_job_2.length) {
				if(length < 1024 && commonByteArray_SFTY_TEST_Test_job_2.length == 0) {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[1024];
				} else {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SFTY_TEST_Test_job_2, 0, length);
			strReturn = new String(commonByteArray_SFTY_TEST_Test_job_2, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SFTY_TEST_Test_job_2.length) {
				if(length < 1024 && commonByteArray_SFTY_TEST_Test_job_2.length == 0) {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[1024];
				} else {
   					commonByteArray_SFTY_TEST_Test_job_2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_SFTY_TEST_Test_job_2, 0, length);
			strReturn = new String(commonByteArray_SFTY_TEST_Test_job_2, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
					this.S_CITY = readString(dis);
					
					this.E_CITY = readString(dis);
					
					this.VACATION = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DISTANCE = null;
           				} else {
           			    	this.DISTANCE = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.FARE = null;
           				} else {
           			    	this.FARE = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
					this.S_CITY = readString(dis);
					
					this.E_CITY = readString(dis);
					
					this.VACATION = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DISTANCE = null;
           				} else {
           			    	this.DISTANCE = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.FARE = null;
           				} else {
           			    	this.FARE = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
					// String
				
						writeString(this.S_CITY,dos);
					
					// String
				
						writeString(this.E_CITY,dos);
					
					// String
				
						writeString(this.VACATION,dos);
					
					// Long
				
						if(this.DISTANCE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.DISTANCE);
		            	}
					
					// Double
				
						if(this.FARE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.FARE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
					// String
				
						writeString(this.S_CITY,dos);
					
					// String
				
						writeString(this.E_CITY,dos);
					
					// String
				
						writeString(this.VACATION,dos);
					
					// Long
				
						if(this.DISTANCE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.DISTANCE);
		            	}
					
					// Double
				
						if(this.FARE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.FARE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("serial_id="+String.valueOf(serial_id));
		sb.append(",S_CITY="+S_CITY);
		sb.append(",E_CITY="+E_CITY);
		sb.append(",VACATION="+VACATION);
		sb.append(",DISTANCE="+String.valueOf(DISTANCE));
		sb.append(",FARE="+String.valueOf(FARE));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(serial_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(serial_id);
            			}
            		
        			sb.append("|");
        		
        				if(S_CITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_CITY);
            			}
            		
        			sb.append("|");
        		
        				if(E_CITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_CITY);
            			}
            		
        			sb.append("|");
        		
        				if(VACATION == null){
        					sb.append("<null>");
        				}else{
            				sb.append(VACATION);
            			}
            		
        			sb.append("|");
        		
        				if(DISTANCE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(DISTANCE);
            			}
            		
        			sb.append("|");
        		
        				if(FARE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(FARE);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_2Process(globalMap);

		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();





	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"out1");
			
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
                    log4jParamters_tLogRow_1.append("Parameters:");
                            log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
				talendJobLogProcess(globalMap);
			}
			

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[10];

        public void addRow(String[] row) {

            for (int i = 0; i < 10; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 9 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 9 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%3$-");
        			        sbformat.append(colLengths[2]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%4$-");
        			        sbformat.append(colLengths[3]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%5$-");
        			        sbformat.append(colLengths[4]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%6$-");
        			        sbformat.append(colLengths[5]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%7$-");
        			        sbformat.append(colLengths[6]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%8$-");
        			        sbformat.append(colLengths[7]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%9$-");
        			        sbformat.append(colLengths[8]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%10$-");
        			        sbformat.append(colLengths[9]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                    for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                    for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);
                
                    //last column
                    for (int i = 0; i < colLengths[9] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"serial_id","S_CITY","E_CITY","VACATION","DISTANCE","FARE","S_INCOME","E_INCOME","S_POP","E_POP",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1");
			
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row1_tMap_1 = 0;
		
		int count_row2_tMap_1 = 0;
		
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_1 = 0;
				
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";
	
	
			cLabel="\"airfares_1\"";
		
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "V9_X");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("HOST" + " = " + "\"192.168.1.95\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PORT" + " = " + "\"5432\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"postgres\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SCHEMA_DB" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USER" + " = " + "\"postgres\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:RLRQUwR2CG0K5nrxL45wDSKTBNr87jDUP5mO7Xnc8fS0RFMB").substring(0, 4) + "...");     
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT    \\\"airfares_1\\\".\\\"serial_id\\\",    \\\"airfares_1\\\".\\\"S_CITY\\\",    \\\"airfares_1\\\".\\\"E_CITY\\\",    \\\"airfares_1\\\".\\\"VACATION\\\",    \\\"airfares_1\\\".\\\"DISTANCE\\\",    \\\"airfares_1\\\".\\\"FARE\\\" FROM \\\"airfares_1\\\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("serial_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("S_CITY")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("E_CITY")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("VACATION")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("DISTANCE")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("FARE")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "\"airfares_1\"", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "postgres";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:I2rAS2MW+z6kOIUsMJIMzZjhhiSl8F0yynXM0wVUjATIEWDo");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
				String url_tDBInput_1 = "jdbc:postgresql://" + "192.168.1.95" + ":" + "5432" + "/" + "postgres";
				
	    		log.debug("tDBInput_1 - Driver ClassName: "+driverClass_tDBInput_1+".");
			
	    		log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '" + dbUser_tDBInput_1 + "'.");
			
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
	    		log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");
			
		        
	    		log.debug("tDBInput_1 - Connection is set auto commit to 'false'.");
			
				conn_tDBInput_1.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  \"airfares_1\".\"serial_id\", \n  \"airfares_1\".\"S_CITY\", \n  \"airfares_1\".\"E_CITY\", \n  \"airfares_1\"."
+"\"VACATION\", \n  \"airfares_1\".\"DISTANCE\", \n  \"airfares_1\".\"FARE\"\nFROM \"airfares_1\"";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.serial_id = null;
							} else {
		                          
            row1.serial_id = rs_tDBInput_1.getLong(1);
            if(rs_tDBInput_1.wasNull()){
                    row1.serial_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.S_CITY = null;
							} else {
	                         		
        	row1.S_CITY = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.E_CITY = null;
							} else {
	                         		
        	row1.E_CITY = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.VACATION = null;
							} else {
	                         		
        	row1.VACATION = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.DISTANCE = null;
							} else {
		                          
            row1.DISTANCE = rs_tDBInput_1.getLong(5);
            if(rs_tDBInput_1.wasNull()){
                    row1.DISTANCE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.FARE = null;
							} else {
	                         		
            row1.FARE = rs_tDBInput_1.getDouble(6);
            if(rs_tDBInput_1.wasNull()){
                    row1.FARE = null;
            }
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					


 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="\"airfares_1\"";
		

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="\"airfares_1\"";
		

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tDBInput_1","\"airfares_1\"","tPostgresqlInput","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
						row2Struct row2 = null;
					
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.serial_id = row1.serial_id ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.serial_id = '" + row2HashKey.serial_id + "'");
								} // G 071
							

							
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
count_out1_tMap_1++;

out1_tmp.serial_id = row1.serial_id ;
out1_tmp.S_CITY = row1.S_CITY ;
out1_tmp.E_CITY = row1.E_CITY ;
out1_tmp.VACATION = row1.VACATION ;
out1_tmp.DISTANCE = row1.DISTANCE ;
out1_tmp.FARE = row1.FARE ;
out1_tmp.S_INCOME = row2.S_INCOME ;
out1_tmp.E_INCOME = row2.E_INCOME ;
out1_tmp.S_POP = row2.S_POP ;
out1_tmp.E_POP = row2.E_POP ;
out1 = out1_tmp;
log.debug("tMap_1 - Outputting the record " + count_out1_tMap_1 + " of the output table 'out1'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"out1","tMap_1","tMap_1","tMap","tLogRow_1","tLogRow_1","tLogRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("out1 - " + (out1==null? "": out1.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[10];
   				
	    		if(out1.serial_id != null) { //              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(out1.serial_id)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.S_CITY != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(out1.S_CITY)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.E_CITY != null) { //              
                 row_tLogRow_1[2]=    						    
				                String.valueOf(out1.E_CITY)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.VACATION != null) { //              
                 row_tLogRow_1[3]=    						    
				                String.valueOf(out1.VACATION)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.DISTANCE != null) { //              
                 row_tLogRow_1[4]=    						    
				                String.valueOf(out1.DISTANCE)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.FARE != null) { //              
                 row_tLogRow_1[5]=    						
								FormatterUtils.formatUnwithE(out1.FARE)
					          ;	
							
	    		} //			
    			   				
	    		if(out1.S_INCOME != null) { //              
                 row_tLogRow_1[6]=    						    
				                String.valueOf(out1.S_INCOME)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.E_INCOME != null) { //              
                 row_tLogRow_1[7]=    						    
				                String.valueOf(out1.E_INCOME)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.S_POP != null) { //              
                 row_tLogRow_1[8]=    						    
				                String.valueOf(out1.S_POP)			
					          ;	
							
	    		} //			
    			   				
	    		if(out1.E_POP != null) { //              
                 row_tLogRow_1[9]=    						    
				                String.valueOf(out1.E_POP)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
                	log.info("tLogRow_1 - Content of row "+nb_line_tLogRow_1+": " + TalendString.unionString("|",row_tLogRow_1));
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="\"airfares_1\"";
		

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="\"airfares_1\"";
		

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
	if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
		
	    		log.debug("tDBInput_1 - Connection starting to commit.");
			
			conn_tDBInput_1.commit();
			
	    		log.debug("tDBInput_1 - Connection commit has succeeded.");
			
		
	    		log.debug("tDBInput_1 - Closing the connection to the database.");
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_1 - Connection to the database closed.");
			
	}
	
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tDBInput_1","\"airfares_1\"","tPostgresqlInput","tMap_1","tMap_1","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"out1",2,0,
			 			"tMap_1","tMap_1","tMap","tLogRow_1","tLogRow_1","tLogRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="\"airfares_1\"";
		

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";
	
	

 



/**
 * [tLogRow_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_SFTY_TEST_Test_job_2 = new byte[0];
    static byte[] commonByteArray_SFTY_TEST_Test_job_2 = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long serial_id;

				public Long getSerial_id () {
					return this.serial_id;
				}

				public Boolean serial_idIsNullable(){
				    return true;
				}
				public Boolean serial_idIsKey(){
				    return false;
				}
				public Integer serial_idLength(){
				    return 19;
				}
				public Integer serial_idPrecision(){
				    return 0;
				}
				public String serial_idDefault(){
				
					return null;
				
				}
				public String serial_idComment(){
				
				    return "";
				
				}
				public String serial_idPattern(){
				
					return "";
				
				}
				public String serial_idOriginalDbColumnName(){
				
					return "serial_id";
				
				}

				
			    public Long S_INCOME;

				public Long getS_INCOME () {
					return this.S_INCOME;
				}

				public Boolean S_INCOMEIsNullable(){
				    return true;
				}
				public Boolean S_INCOMEIsKey(){
				    return false;
				}
				public Integer S_INCOMELength(){
				    return 19;
				}
				public Integer S_INCOMEPrecision(){
				    return 0;
				}
				public String S_INCOMEDefault(){
				
					return null;
				
				}
				public String S_INCOMEComment(){
				
				    return "";
				
				}
				public String S_INCOMEPattern(){
				
					return "";
				
				}
				public String S_INCOMEOriginalDbColumnName(){
				
					return "S_INCOME";
				
				}

				
			    public Long E_INCOME;

				public Long getE_INCOME () {
					return this.E_INCOME;
				}

				public Boolean E_INCOMEIsNullable(){
				    return true;
				}
				public Boolean E_INCOMEIsKey(){
				    return false;
				}
				public Integer E_INCOMELength(){
				    return 19;
				}
				public Integer E_INCOMEPrecision(){
				    return 0;
				}
				public String E_INCOMEDefault(){
				
					return null;
				
				}
				public String E_INCOMEComment(){
				
				    return "";
				
				}
				public String E_INCOMEPattern(){
				
					return "";
				
				}
				public String E_INCOMEOriginalDbColumnName(){
				
					return "E_INCOME";
				
				}

				
			    public Long S_POP;

				public Long getS_POP () {
					return this.S_POP;
				}

				public Boolean S_POPIsNullable(){
				    return true;
				}
				public Boolean S_POPIsKey(){
				    return false;
				}
				public Integer S_POPLength(){
				    return 19;
				}
				public Integer S_POPPrecision(){
				    return 0;
				}
				public String S_POPDefault(){
				
					return null;
				
				}
				public String S_POPComment(){
				
				    return "";
				
				}
				public String S_POPPattern(){
				
					return "";
				
				}
				public String S_POPOriginalDbColumnName(){
				
					return "S_POP";
				
				}

				
			    public Long E_POP;

				public Long getE_POP () {
					return this.E_POP;
				}

				public Boolean E_POPIsNullable(){
				    return true;
				}
				public Boolean E_POPIsKey(){
				    return false;
				}
				public Integer E_POPLength(){
				    return 19;
				}
				public Integer E_POPPrecision(){
				    return 0;
				}
				public String E_POPDefault(){
				
					return null;
				
				}
				public String E_POPComment(){
				
				    return "";
				
				}
				public String E_POPPattern(){
				
					return "";
				
				}
				public String E_POPOriginalDbColumnName(){
				
					return "E_POP";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.serial_id == null) ? 0 : this.serial_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.serial_id == null) {
							if (other.serial_id != null)
								return false;
						
						} else if (!this.serial_id.equals(other.serial_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.serial_id = this.serial_id;
	            other.S_INCOME = this.S_INCOME;
	            other.E_INCOME = this.E_INCOME;
	            other.S_POP = this.S_POP;
	            other.E_POP = this.E_POP;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.serial_id = this.serial_id;
	            	
	}




    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_SFTY_TEST_Test_job_2) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.serial_id = null;
           				} else {
           			    	this.serial_id = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.serial_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.serial_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.S_INCOME = null;
           				} else {
           			    	this.S_INCOME = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.E_INCOME = null;
           				} else {
           			    	this.E_INCOME = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.S_POP = null;
           				} else {
           			    	this.S_POP = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.E_POP = null;
           				} else {
           			    	this.E_POP = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.S_INCOME = null;
           				} else {
           			    	this.S_INCOME = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.E_INCOME = null;
           				} else {
           			    	this.E_INCOME = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.S_POP = null;
           				} else {
           			    	this.S_POP = objectIn.readLong();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.E_POP = null;
           				} else {
           			    	this.E_POP = objectIn.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.S_INCOME == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.S_INCOME);
		            	}
					
						if(this.E_INCOME == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.E_INCOME);
		            	}
					
						if(this.S_POP == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.S_POP);
		            	}
					
						if(this.E_POP == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.E_POP);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.S_INCOME == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.S_INCOME);
		            	}
					
						if(this.E_INCOME == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.E_INCOME);
		            	}
					
						if(this.S_POP == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.S_POP);
		            	}
					
						if(this.E_POP == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.E_POP);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("serial_id="+String.valueOf(serial_id));
		sb.append(",S_INCOME="+String.valueOf(S_INCOME));
		sb.append(",E_INCOME="+String.valueOf(E_INCOME));
		sb.append(",S_POP="+String.valueOf(S_POP));
		sb.append(",E_POP="+String.valueOf(E_POP));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(serial_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(serial_id);
            			}
            		
        			sb.append("|");
        		
        				if(S_INCOME == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_INCOME);
            			}
            		
        			sb.append("|");
        		
        				if(E_INCOME == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_INCOME);
            			}
            		
        			sb.append("|");
        		
        				if(S_POP == null){
        					sb.append("<null>");
        				}else{
            				sb.append(S_POP);
            			}
            		
        			sb.append("|");
        		
        				if(E_POP == null){
        					sb.append("<null>");
        				}else{
            				sb.append(E_POP);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.serial_id, other.serial_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tAdvancedHash_row2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"airfares_2\"";
		
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "V9_X");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("HOST" + " = " + "\"192.168.1.95\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PORT" + " = " + "\"5432\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("DBNAME" + " = " + "\"postgres\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("SCHEMA_DB" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USER" + " = " + "\"postgres\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:ojBpau6pFC0LK/7dG2BrUmMMRPwNbKB+NobMDnJp06B57Ws6").substring(0, 4) + "...");     
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT    \\\"airfares_2\\\".\\\"serial_id\\\",    \\\"airfares_2\\\".\\\"S_INCOME\\\",    \\\"airfares_2\\\".\\\"E_INCOME\\\",    \\\"airfares_2\\\".\\\"S_POP\\\",    \\\"airfares_2\\\".\\\"E_POP\\\" FROM \\\"airfares_2\\\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("PROPERTIES" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("serial_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("S_INCOME")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("E_INCOME")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("S_POP")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("E_POP")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_2", "\"airfares_2\"", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "postgres";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:/S9UKAKSzLqU23muP3vF7Qda8dZ/2PLWyeoOAJdzFuoMTeMA");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
				String url_tDBInput_2 = "jdbc:postgresql://" + "192.168.1.95" + ":" + "5432" + "/" + "postgres";
				
	    		log.debug("tDBInput_2 - Driver ClassName: "+driverClass_tDBInput_2+".");
			
	    		log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '" + dbUser_tDBInput_2 + "'.");
			
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
	    		log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");
			
		        
	    		log.debug("tDBInput_2 - Connection is set auto commit to 'false'.");
			
				conn_tDBInput_2.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT \n  \"airfares_2\".\"serial_id\", \n  \"airfares_2\".\"S_INCOME\", \n  \"airfares_2\".\"E_INCOME\", \n  \"airfares_2"
+"\".\"S_POP\", \n  \"airfares_2\".\"E_POP\"\nFROM \"airfares_2\"";
		    
	    		log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");
			

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.serial_id = null;
							} else {
		                          
            row2.serial_id = rs_tDBInput_2.getLong(1);
            if(rs_tDBInput_2.wasNull()){
                    row2.serial_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.S_INCOME = null;
							} else {
		                          
            row2.S_INCOME = rs_tDBInput_2.getLong(2);
            if(rs_tDBInput_2.wasNull()){
                    row2.S_INCOME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.E_INCOME = null;
							} else {
		                          
            row2.E_INCOME = rs_tDBInput_2.getLong(3);
            if(rs_tDBInput_2.wasNull()){
                    row2.E_INCOME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.S_POP = null;
							} else {
		                          
            row2.S_POP = rs_tDBInput_2.getLong(4);
            if(rs_tDBInput_2.wasNull()){
                    row2.S_POP = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.E_POP = null;
							} else {
		                          
            row2.E_POP = rs_tDBInput_2.getLong(5);
            if(rs_tDBInput_2.wasNull()){
                    row2.E_POP = null;
            }
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					


 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"airfares_2\"";
		

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"airfares_2\"";
		

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tDBInput_2","\"airfares_2\"","tPostgresqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.serial_id = row2.serial_id;
				
				row2_HashRow.S_INCOME = row2.S_INCOME;
				
				row2_HashRow.E_INCOME = row2.E_INCOME;
				
				row2_HashRow.S_POP = row2.S_POP;
				
				row2_HashRow.E_POP = row2.E_POP;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"airfares_2\"";
		

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"airfares_2\"";
		

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
	if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
		
	    		log.debug("tDBInput_2 - Connection starting to commit.");
			
			conn_tDBInput_2.commit();
			
	    		log.debug("tDBInput_2 - Connection commit has succeeded.");
			
		
	    		log.debug("tDBInput_2 - Closing the connection to the database.");
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_2 - Connection to the database closed.");
			
	}
	
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

tHash_Lookup_row2.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tDBInput_2","\"airfares_2\"","tPostgresqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	
			cLabel="\"airfares_2\"";
		

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";
	
	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	

public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";
	
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final Test_job_2 Test_job_2Class = new Test_job_2();

        int exitCode = Test_job_2Class.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'Test_job_2' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}
			log.info("TalendJob: 'Test_job_2' - Start.");
		
		
		
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Test_job_2.class.getClassLoader().getResourceAsStream("sfty_test/test_job_2_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Test_job_2.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
    	                defaultProps.load(inContext);
    	                if (inOSGi && jobProperties != null) {
                             java.util.Enumeration<String> keys = jobProperties.keys();
                             while (keys.hasMoreElements()) {
                                 String propKey = keys.nextElement();
                                 if (defaultProps.containsKey(propKey)) {
                                     defaultProps.put(propKey, (String) jobProperties.get(propKey));
                                 }
                             }
    	                }
    	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Test_job_2");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     148927 characters generated by Talend Cloud Data Management Platform 
 *     on the August 17, 2022 at 4:30:54 PM IST
 ************************************************************************************************/