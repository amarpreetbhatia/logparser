/**
 * Local development server
 */
const express = require('express');
const LogDataSummaryService = require('./services/LogDataSummaryService');

const app = express();
const PORT = process.env.PORT || 3000;

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

// Start server
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
  console.log(`Access log summary at: http://localhost:${PORT}/log/summary`);
});
