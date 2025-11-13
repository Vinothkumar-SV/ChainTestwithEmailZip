
# 🧪 ChainTest with Email & ZIP Automation

## 📖 Overview
**ChainTestwithEmailZip** is an automation testing framework designed to execute a sequence of test cases (chained execution) and automatically email the test results as a **ZIP attachment**.  
This framework demonstrates automation best practices using **Selenium with Java**, **TestNG**, and **Maven**, integrated with **Extent Reports** and **JavaMail API** for result sharing.

---

## 🚀 Key Features
- 🔗 **Chained Test Execution** – Automatically triggers dependent tests in a logical order.
- 📬 **Email Notification** – Sends result reports directly to configured email recipients after execution.
- 🗜️ **ZIP Compression** – Compresses test reports and logs before sending.
- 🧾 **Custom Reports** – Integrated with **Extent Reports** for visual test analytics.
- ⚙️ **Configurable Properties** – Email credentials, recipient list, and file paths can be modified easily in `config.properties`.
- 💡 **Reusable Utility Classes** – For Excel data reading, property management, and screenshot capture.

---

## 🧰 Tech Stack

| Category | Tools / Libraries |
|-----------|-------------------|
| **Language** | Java |
| **Automation Framework** | Selenium WebDriver, TestNG |
| **Build Tool** | Maven |
| **Reporting** | Extent Reports |
| **Email Utility** | JavaMail API |
| **File Management** | Apache Commons IO / ZIP |
| **Data Handling** | Excel Reader (Apache POI) |

---

## 📁 Project Structure

ChainTestwithEmailZip
│
├── src/test/java/
│ ├── base/ # Base setup classes (WebDriver, configurations)
│ ├── tests/ # Test classes with chained logic
│ ├── utils/ # Utility classes (Excel, Email, ZIP, Screenshot)
│ └── reports/ # Extent Report HTML output
│
├── src/main/resources/
│ ├── config.properties # Environment & email configuration
│
├── pom.xml # Maven dependencies and build configuration
├── testng.xml # Test suite definition
└── README.md # Project documentation

---

## ⚙️ Configuration Setup

### 1️⃣ Update Config Properties  
In `src/main/resources/config.properties`, set up:
```properties
email.username=yourEmail@gmail.com
email.password=yourPassword
email.to=receiverEmail@gmail.com
report.path=./reports
zip.path=./reports.zip
2️⃣ Add Dependencies (pom.xml)
Make sure the following dependencies are included:
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.25.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.1.1</version>
    </dependency>
    <dependency>
        <groupId>javax.mail</groupId>
        <artifactId>mail</artifactId>
        <version>1.4.7</version>
    </dependency>
</dependencies>
________________________________________
🧩 How to Run the Tests
🖥️ From IDE (Eclipse/IntelliJ)
1.	Right-click on testng.xml
2.	Select Run As → TestNG Suite
💻 From Command Line
mvn clean test
📧 After Execution
•	Test results are generated inside /reports
•	A .zip file is created automatically
•	Email is sent to the configured recipient with the report attached
________________________________________
📸 Example Output
•	Extent Report: reports/ExecutionReport.html
•	Zipped File: reports.zip
•	Email Subject: Automation Test Report - Execution Summary
________________________________________
🤝 Contributions
You’re welcome to contribute!
•	Fork the repository
•	Create a new branch (feature/your-feature-name)
•	Commit changes and raise a pull request
________________________________________
👨‍💻 Author
Vinoth Kumar S
SDET | Automation Enthusiast | Selenium with Java | TestLeaf
📧 vinothkumar.sv@gmail.com
🔗 GitHub Profile
________________________________________
🏁 Future Enhancements
•	🔄 Jenkins CI/CD integration for scheduled runs
•	🐳 Docker containerization for distributed execution
•	☁️ AWS S3 upload for report storage
•	💬 Slack / Teams notification integration
________________________________________
⭐ If you found this project helpful, don’t forget to give it a star! ⭐

---

Would you like me to:
1. Add a badges section (for build status, license, and technologies), or  
2. Include a sample screenshot/report image preview inside the README (for better presentation on GitHub)?

