@testFeature1DataPrep1
@parallel=false
Feature: Karate Feature file

Background: 

Scenario: Data Prep scenario

	Given def uuId = java.util.UUID.randomUUID() + '' 
	Given def currentTimeInmilliseconds = java.lang.System.currentTimeMillis() + ''
	Given def dateTimeInitialised = Java.type('java.time.LocalDateTime') + ''
	
	And print "Inside dataPrep"
	
	Given def testpayload =
	"""
	{
	  "name": "test",
	  "salary": "123",
	  "age": "23"
	}	
	"""
	
		#Random String(only alphabets) of any length
#	Given def random_str = 
#		"""
 #			function(s) {
   #			var text = "";
   #			var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   #			for (var i = 0; i < s; i++)
     #		text += possible.charAt(Math.floor(Math.random() * possible.length));
   #			return text;
 #			}
 #		"""
	
#	Given def doWork =
#	"""
#	function(arg) {
    #var JavaDemo = Java.type('../javacode/JavaDemo');
    #var jd = new JavaDemo();
    #return jd.doWork(arg); 
    #}
#	"""
	#And print "Outside doWork"
# in this case the solitary 'call' argument is of type string
