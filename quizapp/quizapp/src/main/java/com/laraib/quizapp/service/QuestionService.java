//package com.laraib.quizapp.service;
//
//import com.laraib.quizapp.model.Question;
//import com.laraib.quizapp.dao.QuestionDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class QuestionService {
//
//    @Autowired
//    QuestionDao questionDao;
//
//
//    public ResponseEntity< List<Question>> getAllQuestions() {
//        try {
//            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//    }
//
//    public ResponseEntity< List<Question>> getQuestionsByCategory(String category) {
//        try {
//            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.BAD_REQUEST);
//    }
//    public ResponseEntity<String>  addQuestion(Question question) {
//         questionDao.save(question);
//         return new ResponseEntity<>("sucess",HttpStatus.CREATED) ;
//    }
//
//
//
//    public ResponseEntity<String> deleteQuestion(Integer id ) {
//        try {
//            if (questionDao.existsById(id)) { // Check if the question exists
//                questionDao.deleteById(id);   // Perform the deletion
//                return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("An error occurred while deleting the question", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity< String> updateQuestion(Integer id, Question question) {
//        try {
//            if (questionDao.existsById(id)) { // Check if the question exists
//                questionDao.save(question);   // Perform the update
//                return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("An error occurred while updating the question", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//}
package com.laraib.quizapp.service;

import com.laraib.quizapp.model.Question;
import com.laraib.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
