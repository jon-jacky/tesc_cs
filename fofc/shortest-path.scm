;; shortest-path.scm 
;;
;; Based on shortest-path from Paul Graham, "ANSI Common Lisp", p. 52
;; 22-Nov-2000  J. Jacky  Begun, trivial translation from CL to Scheme

;; hard-code both map and route for now
(define (path-demo)
  (let ((infile (open-input-file "c:\\scheme\\puget-cities.txt")))
    (let ((routes (read infile)))
      (shortest-path "Seattle" "Olympia" routes))))
  
(define (shortest-path start end net)
  (bfs end (list (list start)) net))

;; Breadth-first search
(define (bfs end queue net)
  (if (null? queue)
      '()
      (let ((path (car queue)))
        (let ((node (car path)))
          (if (equal? node end) ;; Graham used CL eql
              (reverse path)
              (bfs end 
                   (append (cdr queue)
                           (new-paths path node net))
                   net))))))

(define (new-paths path node net)
  (map (lambda (n) (cons n path)) (cdr (assoc node net))))


