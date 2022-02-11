package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.StudentDao;
import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Student;
import com.wangpeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    ClazzDao clazzDao;

    @Override
    public List<Student> findStudentsByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<Student> students = studentDao.selectStudentsByLimit(begin, size);
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
        }
        return students;
    }

    @Override
    public int getStudentsCount() {
        return studentDao.getStudentsCount();
    }

    @Override
    public int deleteStudents(List<Student> students) {
        return studentDao.deleteStudents(students);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> searchStudents(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Student> students = studentDao.searchStudentsByLimit(map);
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
        }
        return students;
    }

    @Override
    public List<Student> searchStudentsByTeacher(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Student> students = studentDao.searchStudentsByLimitByTeacher(map);
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
        }
        return students;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return studentDao.getSearchCount(searchParam);
    }

    @Override
    public int getSearchCountByTeacher(Map<String, Object> searchParam) {
        return studentDao.getSearchCountByTeacher(searchParam);
    }

    @Override
    public int getStudentsCountByTeacher(int tid) {
        return studentDao.getStudentsCountByTeacher(tid);
    }

    @Override
    public List<Student> findStudentsByPageByTeacher(Integer page, Integer size, int tid) {
        int begin = (page - 1) * size;
        List<Student> students = studentDao.selectStudentsByLimitByTeacher(begin, size, tid);
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
        }
        return students;
    }

    @Override
    public List<Student> findStudentsByOid(int oid) {
        List<Student> students =  studentDao.selectStudentsByOid(oid);
        return students;
    }

    @Override
    public Student findStudentBySid(Integer sid) {
        Student student = studentDao.selectStudent(sid);
        //添加班级名信息
        int cid = student.getCid();
        Clazz clazz = clazzDao.selectClazz(cid);
        student.setCname(clazz.getCname());
        return student;
    }

    @Override
    public String print(HttpServletRequest req){
        // 获取全部学生信息
        List<Student> students = studentDao.selectStudents();

        FileWriter fw = null;
        String fileName = null;
        try {
            // 获取地址
            String path = req.getSession().getServletContext().getRealPath("report");
            File pathFile = new File(path);
            if (!pathFile.exists()) {
                boolean flag = pathFile.mkdirs();
                if (!flag) throw new RuntimeException("创建文件夹失败");
            }
            // 文件地址，文件名是当前时间戳
            long curTime = System.currentTimeMillis();
            fileName = curTime + ".csv";
            String filePath = path + "/" + fileName;
            // 创建文件
            File file = new File(filePath);
            if (!file.exists()) {
                boolean flag = file.createNewFile();
                if (!flag) throw new RuntimeException("创建文件失败");
            }
            // 写文件
            fw = new FileWriter(file, true);
            fw.write("序号,姓名,学号,性别,年龄,班级,状态,备注,身份证号,电话,地址,进校时间,密码,照片\n");
            // 遍历学生信息
            for (Student student : students) {
                fw.write(student.getSid() + ",");
                fw.write(student.getSname() + ",");
                fw.write(student.getSnum() + ",");
                fw.write(student.getSsex() + ",");
                fw.write(student.getSage() + ",");
                fw.write(student.getCname() + ",");
                fw.write(student.getSstatus() + ",");
                fw.write(student.getSremark() + ",");
                fw.write(student.getIdcard() + ",");
                fw.write(student.getPhone() + ",");
                fw.write(student.getAddress() + ",");
                fw.write(student.getEntime() + ",");
                fw.write(student.getPswd() + ",");
                fw.write(student.getPic() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "http://localhost:8080/StudentManager/report/" + fileName;
    }
}
