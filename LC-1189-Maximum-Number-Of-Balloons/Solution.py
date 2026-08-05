class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        if len(text) < 7:
            return 0
        
        bal = "balloon"
        balMap = {}
        textMap = {}

        for c in bal:
            balMap[c] = balMap.get(c, 0) + 1

        for c in text:
            textMap[c] = textMap.get(c, 0) + 1
        
        count = sys.maxsize
        for key in balMap.keys():
            if key in textMap:
                count = min(count, textMap[key] // balMap[key])
            else:
                return 0
        
        return count
        