const fs = require('fs');
const path = require('path');
const LogData = require('../models/LogData');
const DateConverterUtil = require('../utils/DateConverterUtil');

/**
 * Service to load and parse log data from file
 */
class LogDataLoader {
  /**
   * Load log data from file
   * @param {string} filePath - Path to log file
   * @returns {Array<LogData>} - Array of LogData objects
   */
  static loadLogData(filePath) {
    try {
      // If filePath is not provided, use default
      const logFilePath = filePath || process.env.LOG_FILE_PATH || path.join(__dirname, '../resources/programming-task-example-data.log');
      
      // Read file content
      const fileContent = fs.readFileSync(logFilePath, 'utf8');
      
      // Parse log lines
      return this.parseLogLines(fileContent);
    } catch (error) {
      console.error('Error loading log data:', error);
      throw new Error(`Failed to load log data: ${error.message}`);
    }
  }

  /**
   * Parse log lines into LogData objects
   * @param {string} fileContent - Content of log file
   * @returns {Array<LogData>} - Array of LogData objects
   */
  static parseLogLines(fileContent) {
    const lines = fileContent.split('\n').filter(line => line.trim());
    
    return lines.map(line => {
      // Parse log line using regex
      // Format: 177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] "GET /intranet-analytics/ HTTP/1.1" 200 3574
      const regex = /^(\S+) - - \[(.*?)\] "(\w+) (.*?) HTTP\/\d\.\d" (\d+) \d+/;
      const match = line.match(regex);
      
      if (match) {
        const [, ipAddress, dateStr, method, url, statusCode] = match;
        const date = DateConverterUtil.parseLogDate(dateStr);
        const httpStatus = parseInt(statusCode, 10);
        
        return new LogData(ipAddress, date, url, httpStatus);
      }
      
      return null;
    }).filter(Boolean); // Remove null entries
  }
}

module.exports = LogDataLoader;
