package org.video.cms.data.repository.concrete;

import org.video.cms.data.entity.Member;
import org.video.cms.data.repository.DataRepository;
import java.util.Optional;

/**
 * @author bobo
 * @date 2020/12/3
 */

public interface MemberRepository extends DataRepository<Member,String> {
    @Override
    Optional<Member> findById(String id);
}
