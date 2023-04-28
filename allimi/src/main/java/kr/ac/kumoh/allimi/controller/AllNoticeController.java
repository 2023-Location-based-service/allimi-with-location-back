//package kr.ac.kumoh.allimi.controller;
//
//import kr.ac.kumoh.allimi.dto.notice.NoticeEditDto;
//import kr.ac.kumoh.allimi.dto.notice.NoticeListDTO;
//import kr.ac.kumoh.allimi.dto.notice.NoticeResponse;
//import kr.ac.kumoh.allimi.dto.notice.NoticeWriteDto;
//import kr.ac.kumoh.allimi.exception.user.UserAuthException;
//import kr.ac.kumoh.allimi.service.NoticeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RestController
//public class AllNoticeController {
//    private final AllNoticeService allNoticeService;
////
////    @PostMapping("/v2/all-notices") // 알림장 작성
////    public ResponseEntity noticeWrite(@RequestBody NoticeWriteDto dto) {
//////    Long noticeId;
////        try {
////            noticeService.write(dto);
////        } catch (UserAuthException e) { //알림장 쓸 권한 없음
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////        } catch (Exception e) { //알림장 쓰기 실패
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////        }
////
////        return ResponseEntity.status(HttpStatus.OK).build();
////    }
////
////    @GetMapping("/v2/all-notices/{resident_id}") // 알림장 목록
////    public ResponseEntity noticeList(@PathVariable("resident_id") Long residentId) {
////        List<NoticeListDTO> noticeList;
////
////        try {
////            noticeList = noticeService.noticeList(residentId);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////        }
////
////        return ResponseEntity.status(HttpStatus.OK).body(noticeList);
////    }
////
////    @GetMapping("/v2/all-notices/detail/{notice_id}") // 알림장 상세보기
////    public ResponseEntity noticeDetail(@PathVariable("notice_id") Long noticeId) {
////        NoticeResponse noticeResponse;
////
////        if (noticeId == null)
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////
////        try {
////            noticeResponse = noticeService.getDetail(noticeId);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////        }
////
////        return ResponseEntity.status(HttpStatus.ACCEPTED).body(noticeResponse);
////    }
////
////    @PatchMapping("/v2/all-notices") // 알림장 수정
////    public ResponseEntity noticeEdit(@RequestBody NoticeEditDto dto) {
////        try {
////            noticeService.edit(dto);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////        }
////
////        return ResponseEntity.status(HttpStatus.OK).build();
////    }
////
////    @DeleteMapping("/v2/all-notices") // 알림장 삭제
////    public ResponseEntity noticeDelete(@RequestBody Map<String, Long> notice) {
////        Long noticeId = notice.get("notice_id");
////
////        if (noticeId == null)
////            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
////
////        Long deletedCnt = noticeService.delete(notice.get("notice_id"));
////
////        if (deletedCnt == 0)
////            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
////
////        return ResponseEntity.status(HttpStatus.OK).build();
////    }
//}
//