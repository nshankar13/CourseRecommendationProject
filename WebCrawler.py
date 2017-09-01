from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
from selenium.common.exceptions import NoSuchElementException
import pdb
from urllib.parse import urljoin
import csv

#chromedriver = 'C:\\chromedriver.exe'
#browser = webdriver.Chrome('C:/Users/nshankar13/Documents/Movie Recommendations Project/chromedriver_win32')
#browser.get('https://fed.princeton.edu/cas/login?locale=en&service=http%3A%2F%2Frecal.io%2Flogin%2F%3Fnext%3D%252F')

browser = webdriver.Firefox(executable_path='C:/Users/nshankar13/Documents/Movie Recommendations Project/geckodriver-v0.18.0-win64/geckodriver.exe')
browser.get('https://fed.princeton.edu/cas/login?locale=en&service=http%3A%2F%2Frecal.io%2Flogin%2F%3Fnext%3D%252F')

username = browser.find_element_by_id("username")
password = browser.find_element_by_id("password")

username.send_keys("*********")
password.send_keys("********")

browser.find_element_by_name("submit").click()

time.sleep(20)

browser.get("http://recal.io/")

time.sleep(5)

# one segment of the stringarray of courses. 
stringArray = ["AAS 201", "AAS 245", "AAS 353", "AAS 367", "AAS 316", "AAS 256", "AFS 407", "AFS 313", "AFS 262", 
"AMS 390", "AMS 399", "AMS 336", "AMS 370", "AMS 391", "AMS 341", "ANT 201", "ANT 208", "ANT 309A", "ANT 309B", 
"ANT 385", "ANT 380", "AOS 527", "AOS 571", "AOS 563", "APC 503", "APC 524", "APC 502", "APC 192", "APC 321",
"ARC 203", "ARC 308", "ARC 311", "ARC 374", "ARC 510", "ARC 210", "ART 245", "ART 328", "ART 100", "ART 204",
"ART 210", "ART 213", "ART 217", "ART 228", "ART 272", "AST 557", "AST 506", "AST 557", "AST 506", "AST 205", 
"AST 301", "AST 522", "CBE 245", "CBE 250", "CBE 260", "CBE 262", "CBE 341", "CBE 433", "CBE 442", "CBE 504", 
"CBE 526", "CBE 524", "CBE 418", "CBE 566", "CBE 228", "CBE 305", "CBE 215", "CBE 434", "CEE 207", "CEE 305",
"CEE 361", "CEE 366", "CEE 439", "CEE 477", "CEE 513", "CEE 538", "CEE 539", "CEE 571", "CEE 581", "CEE 506", 
"CEE 360", "CEE 323", "CEE 561", "CEE 418", "CGS 205", "CGS 254", "CHM 527", "CHM 201", "CHM 207", "CHM 303",
"CHM 305", "CHM 371", "CHM 403", "CHM 407", "CHM 440", "CHM 501", "CHM 503", "CHM 515", "CHM 522", "CHM 529",
"CHM 530", "CHM 532", "CHM 538", "CHM 539", "CHM 232", "CHM 335", "CHM 345", "CHV 310", "CHV 244", "CHV 319",
"CHV 380", "CHV 313", "CHV 301", "CLA 204", "CLA 212", "CLA 219", "CLA 244", "CLA 343", "CLA 301", "COM 202",
"COM 203", "COM 205", "COM 208", "COM 211", "COM 300", "COM 341", "COM 351", "COM 431", "COM 207", "COM 431",
"COM 379", "COM 387", "COM 393", "COM 507", "COM 209", "COS 109", "COS 126", "COS 217", "COS 226", "COS 318",
"COS 324", "COS 326", "COS 333", "COS 340", "COS 418", "COS 429", "COS 432", "COS 436", "COS 451", "COS 487",
"COS 496", "COS 513", "COS 516", "COS 521", "COS 533", "COS 561", "COS 306", "COS 381", "COS 396", "COS 462",
"COS 231", "COS 232", "COS 314", "COS 323", "COS 455", "AST 255A", "EAS 217", "EAS 209", "EAS 216", "EAS 362",
"ECO 100", "ECO 101", "ECO 300", "ECO 302", "ECO 310", "ECO 312", "ECO 317", "ECO 321", "ECO 324", "ECO 326", 
"ECO 331", "ECO 342", "ECO 343", "ECO 353", "ECO 362", "ECO 372", "ECO 382", "ECO 418", "ECO 464", "ECO 465",
"ECO 466", "ECO 467", "ECO 494", "ECO 501", "ECO 503", "ECO 507", "ECO 541", "ECO 513", "ECO 514",
"ECO 517", "ECO 520", "ECO 521", "ECO 523", "ECO 525", "ECO 529", "ECO 531", "ECO 541", "ECO 551", "ECO 553",
"ECO 562", "ECO 565", "ECO 328", "ECO 359", "ECO 329", "ECO 349", "ECS 341", "ECS 364", "ECS 332", "EEB 211", 
"EEB 308", "EEB 309", "EEB 313", "EEB 321", "EEB 327", "EEB 329", "EEB 409", "EEB 507", "EEB 304", "EEB 255A",
"EEB 214", "EEB 215", "EGR 260", "EGR 263", "EGR 102A", "EGR 102B", "EGR 109", "EGR 126", "EGR 191", "EGR 192",
"EGR 200", "EGR 201", "EGR 385", "EGR 475", "EGR 488", "EGR 491", "EGR 494", "EGR 497", "EGR 431", "EGR 228",
"EGR 305", "EGR 245", "EGR 309"]

with open('ratingDataLectures.csv', 'w', newline='') as fp:
    a = csv.writer(fp, delimiter=',')
    a.writerows([["Course Name", "Lecture Rating", "Precept Rating", "Reading Rating", 
        "Papers Rating", "Overall Rating", "Feedback Rating"]])
    for s in stringArray: 
        browser.get("https://reg-captiva.princeton.edu/chart/search.php")
        time.sleep(5)
        inputBoxSubject = browser.find_element_by_id("subject")
        inputBoxCourse = browser.find_element_by_id("courseNumb")
        text = s.split()
        inputBoxSubject.send_keys(text[0])
        inputBoxCourse.send_keys(text[1])
        time.sleep(6)
        try: 
            link = browser.find_element_by_partial_link_text(s)
            link.click()
            browser.implicitly_wait(7)
            tspans = browser.find_element_by_id('chart').find_elements_by_tag_name("tspan")
            values = map(lambda x: x.get_attribute('innerHTML'), tspans)
            lis = list(values)
            length = len(lis)
            lectureRating = lis[length-2],
            preceptRating =  lis[length-3],
            readingRating =  lis[length-4],
            papersRating = lis[length-5],
            overallRating =  lis[length-6],
            feedbackRating =  lis[length-7]
            a.writerows([[s, lectureRating, preceptRating, readingRating, papersRating, overallRating, feedbackRating]])
        except NoSuchElementException: 
            browser.get("https://reg-captiva.princeton.edu/chart/search.php")




#browser.implicitly_wait(10)
 #       urlPrev = browser.current_url
  #      browser.switch_to_frame(browser.find_element_by_id("courseEvaluation"))
   #     src = browser.find_element_by_id("courseEvaluation").get_attribute("src")
    #    url = urljoin(urlPrev, src)
     #   browser.get(url)
      #  time.sleep(5)












