set shiftwidth=2    " two spaces per indent
set tabstop=2       " number of spaces per tab in display
set softtabstop=2   " number of spaces per tab when inserting
set expandtab       " substitute spaces for tabs

set nocp
filetype plugin on

" Normally we use vim-extensions. If you want true vi-compatibility
" remove change the following statements
set nocompatible        " Use Vim defaults instead of 100% vi compatibility
set backspace=indent,eol,start  " more powerful backspacing

" Now we set some defaults for the editor
set autoindent          " always set autoindenting on
set hlsearch
set textwidth=0         " Don't wrap words by default
set nobackup            " Don't keep a backup file
set viminfo='20,\"50    " read/write a .viminfo file, don't store more than
                        " 50 lines of registers
set history=50          " keep 50 lines of command line history
set ruler               " show the cursor position all the time

" Suffixes that get lower priority when doing tab completion for filenames.
" These are files we are not likely to want to edit or read.
set suffixes=.bak,~,.swp,.o,.info,.aux,.log,.dvi,.bbl,.blg,.brf,.cb,.ind,.idx,.ilg,.inx,.out,.toc

" We know xterm-debian is a color terminal
if &term =~ "xterm-debian" || &term =~ "xterm-xfree86"
  set t_Co=16
  set t_Sf=[3%dm
  set t_Sb=[4%dm
endif

" Make p in Visual mode replace the selected text with the "" register.
vnoremap p <Esc>:let current_reg = @"<CR>gvdi<C-R>=current_reg<CR><Esc>

" Vim5 and later versions support syntax highlighting. Uncommenting the next
" line enables syntax highlighting by default.
" syntax on

" Debian uses compressed helpfiles. We must inform vim that the main
" helpfiles is compressed. Other helpfiles are stated in the tags-file.
set helpfile=$VIMRUNTIME/doc/help.txt.gz

set history=1024
set magic
syntax on
highlight Comment term=bold ctermfg=7 guifg=#FF005F guibg=gray
set ts=2
set sw=2
set sts=2
set expandtab

" The following are commented out as they cause vim to behave a lot
" different from regular vi. They are highly recommended though.
set showcmd             " Show (partial) command in status line.
set noshowmatch         " Show matching brackets.
set ignorecase          " Do case insensitive matching
set noincsearch         " Incremental search
"set autowrite          " Automatically save before commands like :next and :make
set hlsearch
set nonumber
"set mouse=a

" copy between files
:vmap _Y :w! ~/.vi_tmp<CR>
:nmap _P :r ~/.vi_tmp<CR>

" tree
:nmap <silent> <c-n> :NERDTreeToggle<CR>

:vmap gb :<C-U>!git blame % -L<C-R>=line("'<") <CR>,<C-R>=line("'>") <CR><CR>
:set guifont=MiscFixed

colorscheme default

" Make curr window 80chars
set winwidth=80
nmap <Tab> <c-w><c-w>
autocmd WinEnter * wincmd =
autocmd VimResized * wincmd =
