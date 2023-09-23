def solution(id_list, report, k):
    #신고하고 처리 결과를 메일로 발송하는 시스템 개발
    #규칙 1 -> 각 유저는 한 번에 한 명의 유저를 신고할 수 있다.
    #규칙 2 -> 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
    #규칙 3 -> k번 이상 신고된 유저는 게시판 이용이 정지됨, 해당 유저를 신고한 모든 유저에게 메일 발송
    
    #id_list -> 전체 유저 목록
    #report -> 신고한 ID
    #k번 신고당하면 정지
    #return은 각 유저가 받은 결과 메일 수
    
    reported_count = {key:0 for key in id_list}
    return_mail = {key:0 for key in id_list}
    stack = set()
    report_len = len(report)
    
    for i in range(report_len):
        reporter,reported = report[i].split(' ')
        if (reporter,reported) not in stack:
            stack.add((reporter,reported))
            reported_count[reported] += 1  
    for i in stack:
        if reported_count[i[1]] >= k:
            return_mail[i[0]] += 1
    
    return list(return_mail.values())