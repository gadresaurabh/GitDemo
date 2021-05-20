@testKarateFeatureFile
@parallel=false
Feature: Karate Feature file

Background: 

	Given def dataPrep = call read('../dataPrep/testFeature1DataPrep1.feature')
#  And print dataPrep

@testKarateCase1GET
Scenario: Test Karate Feature file

	Given url 'http://dummy.restapiexample.com/api/v1/employees'
	When method get 
	Then status 200
	And def resultsGET = response
	And print resultsGET
	And print dataPrep.uuId

@testKarateCase2POST
Scenario: Test Karate Feature file for POST

	Given url 'http://dummy.restapiexample.com/api/v1/create'
	And request
	"""
	{
	  "name": "test",
	  "salary": "123",
	  "age": "23"
	}	
	"""
	When method post
	Then status 200
	And def resultsPOST = response
	And print resultsPOST

@testKarateCase2POSTSample1
Scenario: Test Karate Feature file for POST

	Given url 'http://dummy.restapiexample.com/api/v1/create'
	And request
	"""
	{
	  "name": "test",
	  "salary": "111",
	  "age": "23"
	}	
	"""
	When method post
	Then status 200
	And def resultsPOST = response
	And print resultsPOST
	
@testKarateCase2POSTRAMLCases
Scenario Outline: Test Karate Feature file for POST RAML cases 

	Given url 'http://dummy.restapiexample.com/api/v1/create'
	And def json = dataPrep.testpayload
	And remove json.<jSonPath>
	And request json
	When method post
	And assert result = responseStatus == <Status>
	
Examples:
	|jSonPath|Status|
	|name|200|
	|salary|200|
	|age|200|