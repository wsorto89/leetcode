/**
 * @param {string[]} emails
 * @return {number}
 */
var numUniqueEmails = function(emails) {
    const emailSet = new Set();
    emails.map(email => {
        email = Array.from(email);
        let localName = "";
        let domain = "";
        let domainStart = false;
        let ignore = false;
        email.map(char => {
            if(!domainStart) {
                if(char === "@") {
                    domainStart = true;
                    domain += char;
                }
                else if(char === ".") {
                }
                else if(char === "+") {
                    ignore = true;
                }
                else if(!ignore) {
                    localName += char;
                }
            } else {
                domain += char;
            }
        });
        const curEmail = localName + domain;
        emailSet.add(curEmail);
    });
    
    return emailSet.size;
};
