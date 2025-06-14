/**
 * LogDataSummaryDetail model - represents the summary of log data
 */
class LogDataSummaryDetail {
  constructor(numberOfUnique, top3Urls, top3Ips) {
    this.numberOfUnique = numberOfUnique;
    this.top3Urls = top3Urls;
    this.top3Ips = top3Ips;
  }
}

module.exports = LogDataSummaryDetail;
