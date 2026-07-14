package com.tej.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String mySelf(){
        return "<h1>Yagnatejeswar Reddy</h1>" +
                "I am an aspiring fullstack developer currently looking for opportunities where i can contribute my sel and grow as a developer" +
                "<ul>" +
                    "<li>Email: kampalletej@gmail.com</li>" +
                    "<li>LinkedIn: https://www.linkedin.com/in/yagnatejeswar-reddy/</li>" +
                    "<li>GitHub: https://github.com/tej53</li>" +
                    "<li>LeetCode: https://leetcode.com/u/Yagnatejeswar_Reddy/</li>"+
                "</ul>";
    }

    @GetMapping("/skills")
    public String mySkills(){
        return "<h1>Skills</h1>" +
                "<b>Languages</b> : Java, C, C++, Python, HTML, Javascript<br>" +
                "<b>Frameworks</b> : Express.js, Node.js, React.js<br>" +
                "<b>Databases</b> : MySql, PostgresSQL, MongoDB<br>" +
                "<b>Soft Skills</b> : Problem Solving, Leadership, Team Player<br>" ;
    }

    @GetMapping("/education")
    public String myEducation(){
        return "<h1>Education</h1>" +

                "<h2>Graduation</h2>"+
                "<ul>" +
                    "<li>Lovely Professional University</li>" +
                    "<li>Phagwara, Punjab</li>" +
                    "<li>2023 - 2027</li>" +
                "</ul><br>" +

                "<h2>Intermediate</h2>" +
                "<ul>" +
                    "<li>Narayana Junior College</li>" +
                    "<li>Tirupati, Andhra Pradesh</li>" +
                    "<li>2021 - 2023</li>" +
                "</ul><br>"+

                "<h2>Matriculation</h2>" +
                "<ul>" +
                    "<li>ST. Mary's EM High School</li>" +
                    "<li>Bangarupalyam, Andhra Pradesh</li>" +
                    "<li>2021<li>" +
                "</ul>";
    }

    @GetMapping("/projects")
    public String myProjects(){
        return "<h1>Projects</h1>" +
                "<h2>NexaBot | React, Node.js, Express, FireBase</h2>" +
                "<ul>" +
                    "<li>Built an AI-powered coding practice platform with a real-time code editor, integrating the Groq LLM API to deliver\n" +
                "instant, context-aware feedback on user submissions and simulater</li>" +
                    "<li>Engineered a Node.js/Express backend with Firebase for secure user authentication, session management,\n" +
                "and persistent performance tracking across concurrent user</li>" +
                    "<li>Implemented smart question recommendations and a performance insights dashboard using React with Framer\n" +
                "Motion animations, enabling personalized learning paths</li>" +
                "</ul><br>" +

                "<h2>LocalEats | React, Node.js, Express</h2>" +
                "<ul>" +
                    "<li>Developed a full-stack campus food ordering platform enabling students to browse multi-vendor menus, search and\n" +
                "filter items, and place orders through a responsive, mobile-friendly React</li>" +
                    "<li>Engineered a Node.js/Express backend with MongoDB/Mongoose for scalable multi-vendor menu data\n" +
                "management, designing RESTful APIs to handle dynamic stall listings and efficient vendor-student order\n" +
                "interactive</li>" +
                    "<li>Built an intuitive, mobile-friendly frontend interface using HTML, Tailwind CSS, and JavaScript, significantly\n" +
                "improving accessibility and users</li>" +
                "</ul>";
    }
}
