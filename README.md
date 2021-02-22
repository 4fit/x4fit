# X4FIT - "IT'S FOR FIT" WEB HỎI ĐÁP DÀNH CHO FIT

[![HitCount](http://hits.dwyl.com/4fit/x4fit.svg)](http://hits.dwyl.com/4fit/x4fit)
![GitHub contributors](https://img.shields.io/github/contributors/4fit/x4fit)
![GitHub issues](https://img.shields.io/github/issues/4fit/x4fit?color=red)
![GitHub top language](https://img.shields.io/github/languages/top/4fit/x4fit?color=cyan)
![GitHub repo size](https://img.shields.io/github/repo-size/4fit/x4fit)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/4fit/x4fit)
![Github total lines](https://sloc.xyz/github/4fit/x4fit)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/4fit/x4fit?color=g)
![GitHub last commit](https://img.shields.io/github/last-commit/4fit/x4fit?color=yellow)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/4fit/x4fit)

## Link website
https://x4fit.herokuapp.com/

## Deploy

- 1. Mở CMD/PowerShell
- 2. Đăng nhập vào heroku

```bash
heroku login
```

- 2.1. Cài thêm plugin java (nếu lần đầu deploy)

```bash
heroku plugins:install java
```

- 3. Export project ra file *.war

- 4. Deploy file war lên heroku

  - Cú pháp:
  
```bash
heroku war:deploy <path đến file *.war> -a <tên app heroku>
```

  - Cụ thể:
  
```bash
heroku war:deploy x4fit.war -a x4fit
```

