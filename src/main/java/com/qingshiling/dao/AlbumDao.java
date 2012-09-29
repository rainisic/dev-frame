/* @(#) AlbumDao.java
 * Project:	dev-frame
 * Package: com.qingshiling.dao
 * Author:	rainisic
 * Date:	Sep 29, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.dao;

import org.springframework.stereotype.Repository;

import com.frame.dao.AdvancedHibernateDao;
import com.qingshiling.entity.Album;

/**
 * Data access class for the table "Album".
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class AlbumDao extends AdvancedHibernateDao<Album> {

}
