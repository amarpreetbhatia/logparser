const LogDataService = require('./LogDataService');
const LogDataSummaryDetail = require('../models/LogDataSummaryDetail');

/**
 * Service to generate log data summary
 */
class LogDataSummaryService {
  constructor(logFilePath) {
    this.logDataService = new LogDataService(logFilePath);
  }

  /**
   * Fetch log data summary
   * @returns {LogDataSummaryDetail} - Summary of log data
   */
  fetchLogDataSummary() {
    // Load data
    this.logDataService.loadData();
    
    // Get unique IP count
    const uniqueIpCount = this.logDataService.getUniqueIpCount();
    
    // Get top 3 URLs
    const top3Urls = this.logDataService.getTopUrls(3);
    
    // Get top 3 IPs
    const top3Ips = this.logDataService.getTopIps(3);
    
    // Create and return summary
    return new LogDataSummaryDetail(
      uniqueIpCount.toString(),
      top3Urls,
      top3Ips
    );
  }
}

module.exports = LogDataSummaryService;
