package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Path;

import java.util.List;

public interface PathDAO {
    List<Path> getPaths();

    void savePath (Path path);

    Path getPath(int id);

    void deletePath(int id);
}
