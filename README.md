# Store Information in MongoDb

The goal of this Spring rest project is to store multi form data (form and binary data in mongo database). It is a spring powered application which stores data in mongo database.
POJO mapping to support BSON which can easily sotred in Mongodb.
CRUD operations using POJO.
Auto wiring of MongoDB

Prerequisites:
1)MongoDB on local machine
2)Java 1.7 or higher
3)Maven


Run:
1) Clone the application
2) Navigate to the cloned folder
3) mvn clean package
4)java -jar target\employeinfo-0.0.1-SNAPSHOT.jar
5)Open a browser and type http://localhost:8080/saveemployee.html  ( Enter First name, Last Name and a Jpeg image and click save)

Create an Employee Repository with Employee First Name, Last Name and Employee Image.

For CRUD operations simple interface to connect 
import com.example.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by vivek on 1/15/2017.
 */
public interface EmployeeDbRepository extends MongoRepository<Employee,String> {
}


Pojo Employee Object
@Document(collection="Employee")
public class Employee {

    @Id
    private ObjectId id;
    @Field("firstName")private String firstName;
    @Field("lastName")private String lastName;
    @Field("employeePicture") private Binary employeePicture;

    @PersistenceConstructor Employee(){}

    @PersistenceConstructor
    public Employee(ObjectId id, String firstName, String lastName, Binary employeePicture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeePicture = employeePicture;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Binary getEmployeePicture() {
        return employeePicture;
    }
}

application.properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=PersonalInfo
spring.http.multipart.max-file-size=2048KB
spring.http.multipart.max-request-size=2049KB






