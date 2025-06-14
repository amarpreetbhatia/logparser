/**
 * Utility for date conversion operations
 */
class DateConverterUtil {
  /**
   * Parse date from log format [10/Jul/2018:22:21:28 +0200]
   * @param {string} dateStr - Date string from log
   * @returns {Date} - JavaScript Date object
   */
  static parseLogDate(dateStr) {
    // Remove brackets and split by colon
    const cleanDateStr = dateStr.replace(/[\[\]]/g, '');
    
    // Split into date and time parts
    const [datePart, timePart, timezone] = cleanDateStr.split(':');
    
    // Parse date part (10/Jul/2018)
    const [day, month, year] = datePart.split('/');
    
    // Map month abbreviation to month number
    const months = {
      'Jan': 0, 'Feb': 1, 'Mar': 2, 'Apr': 3, 'May': 4, 'Jun': 5,
      'Jul': 6, 'Aug': 7, 'Sep': 8, 'Oct': 9, 'Nov': 10, 'Dec': 11
    };
    
    // Parse time part (22:21:28)
    const [hours, minutes, secondsWithTz] = timePart ? timePart.split(':') : [0, 0, 0];
    const seconds = secondsWithTz ? secondsWithTz.split(' ')[0] : 0;
    
    // Create date object
    return new Date(Date.UTC(
      parseInt(year),
      months[month],
      parseInt(day),
      parseInt(hours || 0),
      parseInt(minutes || 0),
      parseInt(seconds || 0)
    ));
  }
}

module.exports = DateConverterUtil;
