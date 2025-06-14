# Testing Strategy

This document outlines the testing strategy for the JavaScript version of the Log Parser application.

## Testing Framework

- **Jest**: Used for unit and integration testing
- **serverless-offline**: Used for local Lambda testing

## Test Types

### Unit Tests

1. **LogDataLoader Tests**
   - Test parsing of log lines
   - Test handling of invalid log formats
   - Test file loading functionality

2. **LogDataService Tests**
   - Test unique IP counting
   - Test top URL identification
   - Test top IP identification
   - Test with mock data

3. **DateConverterUtil Tests**
   - Test parsing of log date format
   - Test handling of edge cases

### Integration Tests

1. **API Endpoint Tests**
   - Test /log/summary endpoint
   - Verify response format
   - Test with sample log data

### Local Testing

1. **Express Server**
   - Run application with `npm start`
   - Test endpoints with browser or tools like Postman
   - Verify functionality before deployment

2. **Serverless Offline**
   - Simulate AWS Lambda environment locally
   - Test with `serverless offline`
   - Verify Lambda-specific behavior

## Test Data

- Sample log data from the original application is used for testing
- Mock data is created for specific test cases
- Edge cases are tested with specially crafted log entries

## Continuous Integration

For future implementation:
- Automated tests on pull requests
- Code coverage reporting
- Integration with GitHub Actions
