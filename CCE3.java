/*
 * What are the basic components of Java AWT.


In Java, AWT (Abstract Window Toolkit) is a set of classes and APIs (Application Programming Interfaces) that provide the foundation for creating graphical user interfaces (GUIs). The basic components of Java AWT include:

Windows and Frames: These are the top-level containers that provide the main window for the GUI application. They can have a title bar, menu bar, and can be resized, minimized, or closed.

*Panels: Panels are containers that hold other components. They are used to organize and group related components together.

*Buttons: Buttons are used to trigger an action when clicked. They can have text, icons, or both.

*Labels: Labels are used to display text or images. They provide information or describe other components.

*Text Fields: Text fields allow users to enter and edit text. They are used to receive input from the user.

*Checkboxes and Radio Buttons: Checkboxes and radio buttons are used for selecting options from a list. Checkboxes allow multiple selections, while radio buttons allow only one selection.

*Lists: Lists display a scrollable list of items from which the user can select one or multiple items.

*Choice Boxes and Combo Boxes: Choice boxes and combo boxes provide a drop-down menu of options from which the user can select one item.

*Scrollbars: Scrollbars are used to navigate through the contents of a component that is too large to fit within the available space.

*Dialogs: Dialogs are windows that are used to display messages, prompt for input, or provide additional information. They can be modal or non-modal.

These are some of the basic components provided by Java AWT. Each component has associated methods and events that allow you to interact with and control their behavior. By combining these components, you can create complex GUI applications in Java.

The execution of an applet program in Java involves several steps:

*Applet Creation: First, you need to create an applet class by extending the java.applet.Applet class or its subclasses. This class will contain the code for your applet's functionality.

*Applet Initialization: The applet's init() method is called when the applet is first loaded. This method is used to initialize the applet, set up the user interface, and perform any necessary setup tasks.

*Applet Configuration: The start() method is called after the applet is initialized. It is used to start or resume the applet's execution. In this method, you can start any background tasks or initiate animations, for example.

*User Interaction: The applet can respond to user input through methods such as mouseClicked(), keyPressed(), or actionPerformed(). These methods are called when the user interacts with the applet, such as clicking a button or pressing a key.

*Rendering: The paint() method is called whenever the applet needs to be visually rendered. You override this method to define what and how the applet should be displayed on the screen.

*Applet Termination: The stop() method is called when the applet is about to be stopped or suspended. This method is typically used to clean up resources and stop any ongoing processes.

Now, let's talk about the Applet Viewer:

The Applet Viewer is a tool that is provided with the Java Development Kit (JDK). It allows you to test and run Java applets on your local machine without the need for a web browser. The Applet Viewer acts as a standalone applet viewer and simulator.

        *To run an applet using the Applet Viewer, you need to have the Java Development Kit installed on your system. Here's how you can use the Applet Viewer:

Write the applet code: Create an applet class that extends java.applet.Applet and implements the necessary methods.

        *Compile the applet: Use the Java compiler (javac) to compile your applet code into bytecode.

Run the applet using the Applet Viewer: Open a command prompt or terminal, navigate to the directory containing the compiled .class file, and use the following command: appletviewer YourAppletClassName.class

    *Replace YourAppletClassName with the name of your applet class file (without the .class extension). The Applet Viewer will open a new window and display your applet.

The Applet Viewer provides a convenient way to test and debug applets locally without the need for a web browser. However, please note that the use of Java applets has significantly declined in recent years, and modern web browsers no longer support them due to security concerns.

*Write a short note on character stream and byte stream with example.

In Java, character streams and byte streams are two fundamental types of I/O streams used for reading and writing data. They handle data at different levels of granularity: character streams work with Unicode characters, while byte streams work with raw binary data. Here's a brief explanation of each:

*Character Streams:

Character streams are used for reading and writing textual data. They handle characters using Unicode encoding, typically UTF-8. They are represented by classes that end with "Reader" for reading and "Writer" for writing.

Example: Reading and Writing Text File using Character Streams
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample {
    public static void main(String[] args) {
        try {
            // Writing to a text file using FileWriter
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, World!");
            writer.close();

            // Reading from a text file using FileReader
            FileReader reader = new FileReader("example.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        try {
            // Writing to a binary file using FileOutputStream
            FileOutputStream outputStream = new FileOutputStream("example.bin");
            byte[] data = {0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x2C, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64, 0x21};
            outputStream.write(data);
            outputStream.close();

            // Reading from a binary file using FileInputStream
            FileInputStream inputStream = new FileInputStream("example.bin");
            int byteValue;
            while ((byteValue = inputStream.read()) != -1) {
                System.out.print((char) byteValue);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample {
    public static void main(String[] args) {
        try {
            // Writing to a text file using FileWriter
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, World!");
            writer.close();

            // Reading from a text file using FileReader
            FileReader reader = new FileReader("example.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        try {
            // Writing to a binary file using FileOutputStream
            FileOutputStream outputStream = new FileOutputStream("example.bin");
            byte[] data = {0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x2C, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64, 0x21};
            outputStream.write(data);
            outputStream.close();

            // Reading from a binary file using FileInputStream
            FileInputStream inputStream = new FileInputStream("example.bin");
            int byteValue;
            while ((byteValue = inputStream.read()) != -1) {
                System.out.print((char) byteValue);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server listening on port 1234...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = reader.readLine();
        System.out.println("Received from client: " + message);

        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        writer.println("Message received by server!");

        writer.close();
        reader.close();
        clientSocket.close();
        serverSocket.close();
    }
}
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server...");

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Hello, Server!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = reader.readLine();
        System.out.println("Response from server: " + response);

        writer.close();
        reader.close();
        socket.close();
    }
}
/*
In this example, the server listens on port 1234 using a ServerSocket. When a client connects to the server, the server accepts the connection using serverSocket.accept(). The server then reads a message from the client, prints it, and sends a response back to the client.

*The client connects to the server using a Socket and sends a message to the server. It then reads the response from the server and prints it.

The java.net.URL class provides methods to access and manipulate URLs. It allows you to establish connections and read data from a specified URL.

*URLs and URIs: URLs (Uniform Resource Locators) and URIs (Uniform Resource Identifiers) are used to identify resources on the internet. 

Reading Data from a URL
*/
import java.io.*;
import java.net.*;

public class URLReader {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
/*
*JDBC (Java Database Connectivity):

JDBC (Java Database Connectivity) and ODBC (Open Database Connectivity) are two different technologies that provide a standard way to interact with databases. Here's an explanation of each:


*JDBC is a Java API that allows Java applications to interact with relational databases. 
    It provides a set of classes and interfaces to connect to a database, execute SQL queries, retrieve and manipulate data, and handle transactions.   
    *JDBC acts as a bridge between Java programs and the database-specific drivers.

Key components of JDBC include:
    
    *JDBC API: The JDBC API consists of interfaces and classes that define methods for connecting to databases, executing SQL statements, and managing result sets.

JDBC Driver: 

*A JDBC driver is a software component that provides the implementation of the JDBC API for a specific database management system (DBMS).
    Each DBMS typically has its own JDBC driver, which needs to be installed and registered to connect to the corresponding database.
JDBC URL:

* A JDBC URL is a string that specifies the address and other details required to establish a connection to a database. The format of the JDBC URL varies depending on the DBMS and the JDBC driver being used.
*/
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Creating a statement for executing SQL queries
            Statement statement = connection.createStatement();

            // Executing a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Processing the result set
            while (resultSet.next()) {
                String employeeName = resultSet.getString("name");
                int employeeAge = resultSet.getInt("age");
                System.out.println("Name: " + employeeName + ", Age: " + employeeAge);
            }

            // Closing the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
