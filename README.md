# Vintra

**Preconditions:**

- Docker (version 3.5+)
- Maven (version 3+)
- Git (version 2+)
- Java JDK (version 1.8+)

**How to get up and running the system under test**

1. Open a terminal and write "docker run -p 8000:8000 -it vintratest/contacts_mvp:latest"
2. Open a browser and put the next URL http://127.0.0.1:8000/health
3. You should see a response in JSON format like:
   "{"pid":9,"rss_bytes":31805440,"num_connections":3,"cpu_percent":"0.0","db_status_ok":true,"num_users":2}"

**How to execute the test suite**

1. Do a git clone from the repository
2. Open a terminal in the same location of the project (inside vintra folder)
3. In the terminal write "**mvn clean install test**"
4. Once the **build** has been **successful**
5. Go to folder **vintra\src\main\resources\reports** and open **spark.html** to see the results report