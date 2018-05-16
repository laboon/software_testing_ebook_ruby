TITLE=A Friendly Introduction\\\\to Software Testing\\\\(with Ruby)
AUTHOR=Bill Laboon
DEDICATION=to Kathy Laboon


# If pandoc or xelatex are not in your PATH, specify their locations here:
PANDOC=	pandoc
XELATEX= xelatex

MD_FILES=	$(wildcard text/*.md)


pdf:	main.tex tex_files
# Uses date of most recent commit in repo
	$(PANDOC) main.tex -o software-testing-laboon-ebook.pdf \
		--pdf-engine $(XELATEX) \
		--top-level-division=chapter \
		--toc --toc-depth=2 \
		-M documentclass="book" \
		-M classoption="twoside" \
		-M classoption="letterpaper" \
		-M geometry="margin=1.25in" \
		-M title="\Huge{\textbf{${TITLE}}}" \
		-M author="\LARGE{${AUTHOR}}" \
		-M date="{\Large\textcopyright~\textbf{$(shell git log -1 --date=iso --format='%ai' | cut -c-10 )}}\\\\Compiled in PDF\LaTeX{}\endgraf\textit{${DEDICATION}}"

tex_files:	compiled_tex/ $(patsubst text/%.md,compiled_tex/%.tex,$(MD_FILES))
compiled_tex/:
	mkdir -p compiled_tex/
compiled_tex/%.tex:	text/%.md
	$(PANDOC) text/$*.md \
		--listings --highlight-style kate \
		-o compiled_tex/$*.tex


clean:
	rm -rf compiled_tex/
	# Remove temporary compilation directories, if they still exist
	rm -rf tex2pdf*/

.PHONY: pdf tex_files clean
