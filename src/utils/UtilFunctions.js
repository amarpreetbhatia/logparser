/**
 * Utility functions for log parsing
 */
class UtilFunctions {
  /**
   * Count occurrences of each item in an array
   * @param {Array} array - Array of items
   * @returns {Object} - Object with counts
   */
  static countOccurrences(array) {
    return array.reduce((acc, curr) => {
      acc[curr] = (acc[curr] || 0) + 1;
      return acc;
    }, {});
  }

  /**
   * Get top N items by occurrence count
   * @param {Object} countMap - Map of items to counts
   * @param {number} n - Number of top items to return
   * @returns {Array} - Array of top N items
   */
  static getTopN(countMap, n) {
    return Object.entries(countMap)
      .sort((a, b) => b[1] - a[1])
      .slice(0, n)
      .map(([item]) => item);
  }
}

module.exports = UtilFunctions;
