#Autor: Diego Fernando Merchan Jimenez

Feature: Management of company employees
  As a system user RestApiExample
  I want to consume the different services provided by the application
  To perform the different actions allowed by the application

  Background:
    Given that 'Diego' wants to manage the company's employee registry

  Scenario: Create a new employee record
    When he create the user 'Maria Hernandez' of '25' years with a salary of '2500000'
    Then he should see the status 'success' and message 'Successfully! Record has been added.'

  Scenario: Delete the record of an employee of the company
    When he deletes the record of the employee with his identifier '2'
    Then he should see the status 'success' and message 'Successfully! Record has been deleted'

  Scenario: Consult the employees who are registered in the company
    When he consults all the employees of the company
    Then he should see the status 'success' and message 'Successfully! All records has been fetched.'

  Scenario Outline: Consult '<name>' one of the company's employees
    When he consults the employee with his identifier '<idEmployee>'
    Then he should see the status 'success' and message 'Successfully! Record has been fetched.'
    And he should see the name '<name>', age '<age>' and salary '<salary>' of the employee
    Examples:
      | idEmployee | name           | age | salary |
      | 1          | Tiger Nixon    | 61  | 320800 |
      | 8          | Rhona Davidson | 55  | 327900 |
      | 16         | Michael Silva  | 66  | 198500 |
      | 23         | Caesar Vance   | 21  | 106450 |