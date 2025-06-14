# Architecture Decisions

This document outlines the key architecture decisions made during the migration from Java to JavaScript for AWS Lambda deployment.

## Technology Stack

- **Runtime**: Node.js (v14+)
- **Framework**: Express.js with serverless-http
- **Deployment**: AWS Lambda via Serverless Framework
- **Testing**: Jest

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

## Key Design Decisions

1. **Serverless Architecture**
   - Used AWS Lambda for scalable, event-driven execution
   - Eliminated need for server management
   - Pay-per-use pricing model

2. **Express.js with serverless-http**
   - Maintained RESTful API structure from original application
   - Used serverless-http to adapt Express.js for Lambda
   - Simplified local development and testing

3. **Modular Code Organization**
   - Separated concerns into models, services, and utilities
   - Maintained similar structure to original Java application
   - Enhanced maintainability and testability

4. **Local Development Support**
   - Added local.js for running the application outside of Lambda
   - Configured serverless-offline for local Lambda simulation
   - Ensured consistent behavior between local and cloud environments

5. **Environment Configuration**
   - Used environment variables for configuration
   - Configured log file path as an environment variable
   - Allowed for different configurations per deployment stage
