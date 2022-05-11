# QualityQuizzes  
### Contributors
    - William Spearman
    - Bret Steadman
    - Damon Akins
### QualityQuizzes Description  
    * Application for creating custom or automated quizzes/tests
    * Allows Teachers to create/delete/update quizzes 
    * Allows Students to take quizzes
    * Users can either be Teacher or Student 
    * Will use an API for generating automatic quizzes
    * Will allow Teacers to input custom questions of their making
### Tech Stack 
    1. Java for Back-end
    2. MariaDB for Database
    3. HTML/CSS/DJANGO for Front-end
### Users
    1. Teachers
    2. Students
### Future Additions
    * Will be hosted on Nginx Server
    * Will be hosted on Virtual Server
    * Will be hosted mapped to a domain
# Abilities
### TEACHERS
        - Create Quizzes
        - Delete Quizzes 
        - Edit Quizzes
        - View Quizzes
### STUDENTS
        - Take Quizzes
        - View Grades
# Coding Style Guide
### Class Sturcture Template 
 ``` 
    public class Foo{
        // properties ////////////////////////////////////////////////////////////// 
        // constants /////////////////////////////////////////////////////////////// 
        // members  //////////////////////////////////////////////////////////////// 
        // constructors //////////////////////////////////////////////////////////// 
        // getters and setters ///////////////////////////////////////////////////// 
        // methods ///////////////////////////////////////////////////////////////// 
        // helper functions  /////////////////////////////////////////////////////// 
    }
 ```

### Class Sturcture Example
```
    public class Movie{
        // properties ////////////////////////////////////////////////////////////// 
        private static final NumberOfMovies++;
        
        // constants  ////////////////////////////////////////////////////////////// 
        private static final Long NumberOfSeats = 24;
        private static final String MovieThreater = 'AMC';
        
        // members  ////////////////////////////////////////////////////////////////
        private final MovieName Dr.Stange
        private int             NumberOfPeopleAttending;
        private int             FoodSold;
        private int             DrinksSold;
        
        // constructors  ////////////////////////////////////////////////////////////// 
       public Movie(){
            this(new Movie());
       }
    }
```
### Rules for using Braces
#### Optional
```
    public boolean thisIsAGreatMovie(response){
        if( response == null) return false;
        if( response == movie.isGood()) return true;
        if( response == movie.isBad()) return false;
    }
```
