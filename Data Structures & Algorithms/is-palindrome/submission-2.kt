class Solution {
    fun isPalindrome(s: String): Boolean {
        val size = s.length
        var pointer1 = 0
        var pointer2 = size-1

        var lowerCasesString = s.lowercase()

        while(pointer1 <= pointer2) {

            val isLetterOrDigit1 = lowerCasesString[pointer1].isLetterOrDigit()
            if(isLetterOrDigit1.not()){
                pointer1 += 1
                continue
            }

            val isLetterOrDigit2 = lowerCasesString[pointer2].isLetterOrDigit()
            if(isLetterOrDigit2.not()) {
                pointer2 -= 1    
                continue
            }
            
            if(lowerCasesString[pointer1] != lowerCasesString[pointer2]) {  
                return false
            }

            pointer1 += 1
            pointer2 -= 1
        }

        return true
    }
}
