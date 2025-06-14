const LogDataLoader = require('./LogDataLoader');
const UtilFunctions = require('../utils/UtilFunctions');

/**
 * Service to process log data
 */
class LogDataService {
  constructor(logFilePath) {
    this.logFilePath = logFilePath;
    this.logData = [];
  }

  /**
   * Load log data
   */
  loadData() {
    this.logData = LogDataLoader.loadLogData(this.logFilePath);
    return this.logData;
  }

  /**
   * Get number of unique IP addresses
   * @returns {number} - Count of unique IPs
   */
  getUniqueIpCount() {
    const uniqueIps = new Set(this.logData.map(log => log.ipAddress));
    return uniqueIps.size;
  }

  /**
   * Get top N most visited URLs
   * @param {number} n - Number of top URLs to return
   * @returns {Array<string>} - Array of top URLs
   */
  getTopUrls(n = 3) {
    const urls = this.logData.map(log => log.url);
    const urlCounts = UtilFunctions.countOccurrences(urls);
    return UtilFunctions.getTopN(urlCounts, n);
  }

  /**
   * Get top N most active IP addresses
   * @param {number} n - Number of top IPs to return
   * @returns {Array<string>} - Array of top IPs
   */
  getTopIps(n = 3) {
    const ips = this.logData.map(log => log.ipAddress);
    const ipCounts = UtilFunctions.countOccurrences(ips);
    return UtilFunctions.getTopN(ipCounts, n);
  }
}

module.exports = LogDataService;
