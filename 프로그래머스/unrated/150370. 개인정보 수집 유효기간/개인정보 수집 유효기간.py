from collections import defaultdict

def solution(today, terms, privacies):
    terms_dict = defaultdict(list)
    answer = []
    
    for term in terms:
        if not terms_dict[term[0]]:
            terms_dict[term[0]] = term[2:]
            
    today_year = int(today[:4])
    today_month = int(today[5:7])
    today_day = int(today[-2:])
    
    for i in range(len(privacies)):
        date_string = privacies[i][:10]
        term_type = privacies[i][11:]
        
        current_year = int(date_string[:4])
        current_month= int(date_string[5:7])
        current_day= int(date_string[-2:])
        
        plus_months=int(terms_dict[term_type])

        expiry_year=current_year+(current_month+plus_months-1)//12
        expiry_month=(current_month+plus_months-1)%12+1
        expiry_day=current_day

        if expiry_year < today_year or (expiry_year == today_year and expiry_month < today_month) or (expiry_year == today_year and expiry_month == today_month and expiry_day <= today_day):
            answer.append(i+1)

    return sorted(answer)
