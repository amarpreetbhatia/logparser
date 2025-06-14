/**
 * LogData model - represents a single log entry
 */
class LogData {
  constructor(ipAddress, date, url, httpStatus) {
    this.ipAddress = ipAddress;
    this.date = date;
    this.url = url;
    this.httpStatus = httpStatus;
  }
}

module.exports = LogData;
