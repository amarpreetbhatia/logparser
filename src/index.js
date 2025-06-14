const serverless = require('serverless-http');
const express = require('express');
const LogDataSummaryService = require('./services/LogDataSummaryService');

const app = express();

// Middleware
app.use(express.json());

// Routes
app.get('/log/summary', (req, res) => {
  try {
    console.log('Log summary endpoint called');
    const logDataSummaryService = new LogDataSummaryService();
    const summary = logDataSummaryService.fetchLogDataSummary();
    res.json(summary);
  } catch (error) {
    console.error('Error processing log summary:', error);
    res.status(500).json({ error: 'Failed to process log data' });
  }
});

// Health check endpoint
app.get('/health', (req, res) => {
  res.status(200).json({ status: 'ok' });
});

// Not found handler
app.use((req, res) => {
  res.status(404).json({ error: 'Not found' });
});

// Error handler
app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).json({ error: 'Internal server error' });
});

// Export the serverless handler
module.exports.handler = serverless(app);
