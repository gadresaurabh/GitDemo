# This is the latest commit from Asian timzone - 21-may at 17:10 PM

Feature: cats end-point

Background:
#	Given def url demoBaseUrl
	Given def dataPrep = call read('../dataPrep/testFeature1DataPrep1.feature')
  #And print dataPrep

@TestJavaFeature
Scenario: pass json to java

# Call without using FUNCTION

#	Given def config = { text: 'Saurabh'}
#	And def JavaClassCall = Java.type('FinalKarateProject.JavaDemo')
#	And def OutputText = new JavaClassCall()
#	And print OutputText.Munna(config)
 	
 	
#	And def JavaClassCall = Java.type('FinalKarateProject.JavaDemo')
#	And def OutputText = new JavaClassCall()
#	And print OutputText.Munna('Chris', 007)
 	
# Call using JAVASCRIPT FUNCTION 
 	
Given def javaClassCallDemo =
"""
function(args1, args2){
	var JavaClassCall = Java.type('FinalKarateProject.JavaDemo');
 	var OutputText = new JavaClassCall();
 	var output =  OutputText.Munna(args1, args2);
 	return output;
}
"""
Given def MeraText =  javaClassCallDemo('Chris', 007)	
And print MeraText
	
	Given url 'http://dummy.restapiexample.com/api/v1/employees'
	When method get 
	Then status 200
	And def resultsGET = response
#	And print resultsGET
	And print dataPrep.uuId
