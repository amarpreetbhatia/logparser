# Log Parser Application (AWS Lambda Version)

This is a modernized JavaScript version of the Log Parser application, designed to run on AWS Lambda.

## Features

1. **Log File Processing** - Reads and parses log files
2. **Data Analysis** - Provides the following insights:
   * The number of unique IP addresses
   * The top 3 most visited URLs
   * The top 3 most active IP addresses
3. **AWS Lambda Ready** - Designed to be deployed as a serverless function
4. **RESTful API** - Exposes endpoints to access log data summaries

## Local Development

### Prerequisites

- Node.js (v14 or later)
- npm or yarn

### Setup

1. Clone the repository:
   ```
   git clone https://github.com/amarpreetbhatia/logparser.git
   cd logparser
   git checkout migration/awslambda
   ```

2. Install dependencies:
   ```
   npm install
   ```

3. Run locally:
   ```
   npm start
   ```

4. Access the API:
   - Log Summary: http://localhost:3000/log/summary
   - Health Check: http://localhost:3000/health

### Testing

Run tests with:
```
npm test
```

## Deployment to AWS Lambda

1. Configure AWS credentials:
   ```
   aws configure
   ```

2. Deploy using Serverless Framework:
   ```
   npm run deploy
   ```

## API Endpoints

- `GET /log/summary` - Returns a summary of log data including unique IP count, top URLs, and top IPs
- `GET /health` - Health check endpoint

## Environment Variables

- `LOG_FILE_PATH` - Path to the log file (defaults to included sample file)

## Project Structure

```
├── src/
│   ├── models/         # Data models
│   ├── services/       # Business logic
│   ├── utils/          # Utility functions
│   ├── resources/      # Resource files (logs)
│   ├── index.js        # Lambda handler
│   └── local.js        # Local development server
├── tests/              # Unit tests
├── serverless.yml      # Serverless configuration
└── package.json        # Project dependencies
```
    
    ```Assumption : Log file format will be fixed and data attributes are mapped to the postion```
3. REST Endpoint is expose to view the summary details from the converted log data

*How To run this project:*

Project is build on JDK11 and maven
   ```mvn spring-boot:run```
And test result:
`curl 'http://localhost:8080/log/summary' \
-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
--compressed`

To run test cases, ```mvn test```
or import project in IDE

Test Cases Path
src/test/java