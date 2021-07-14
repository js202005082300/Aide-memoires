<?php

interface IArticle
{
	const NB_ARTICLES_PAR_PAGE = 10;
	
	public function getNBComments();
	public function create();
	public function save($author, $content);
	public function delete();
}

echo IArticle::NB_ARTICLES_PAR_PAGE;