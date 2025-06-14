# Deployment Guide

This guide provides instructions for deploying the Log Parser application to AWS Lambda.

## Prerequisites

1. **AWS Account**
   - Active AWS account with appropriate permissions
   - AWS CLI configured with credentials

2. **Node.js Environment**
   - Node.js v14 or later
   - npm or yarn package manager

3. **Serverless Framework**
   - Installed globally: `npm install -g serverless`

## Local Development

1. **Install Dependencies**
   ```bash
   npm install
   ```

2. **Run Locally**
   ```bash
   npm start
   ```
   Access the API at http://localhost:3000/log/summary

3. **Run Tests**
   ```bash
   npm test
   ```

## Deployment Steps

1. **Configure AWS Credentials**
   ```bash
   aws configure
   ```
   Enter your AWS Access Key ID, Secret Access Key, and preferred region.

2. **Deploy to AWS Lambda**
   ```bash
   npm run deploy
   ```
   This will deploy using the Serverless Framework.

3. **Custom Deployment Configuration**
   ```bash
   serverless deploy --stage prod --region us-west-2
   ```
   Customize stage and region as needed.

4. **Specify Custom Log File**
   ```bash
   serverless deploy --logfile s3://my-bucket/logs/app.log
   ```
   Use a custom log file path if needed.

## Post-Deployment

1. **Verify Deployment**
   - Check AWS Lambda console
   - Verify API Gateway endpoints
   - Test the deployed API

2. **Monitor Application**
   - Set up CloudWatch Alarms
   - Configure logging
   - Monitor performance metrics

3. **Cleanup**
   ```bash
   serverless remove
   ```
   Remove the deployed resources when no longer needed.

## Troubleshooting

1. **Check Logs**
   ```bash
   serverless logs -f api
   ```
   View Lambda function logs.

2. **Invoke Function Locally**
   ```bash
   serverless invoke local -f api -p events/api-event.json
   ```
   Test function with a sample event.
