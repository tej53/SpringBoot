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
}
