/**
 * 
 */
package com.ecart.searvice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.domain.Navigation;
import com.ecart.domain.NavigationAttributes;
import com.ecart.domain.NavigationBadge;
import com.ecart.domain.NavigationChildren;
import com.ecart.model.NavigationAttributesModel;
import com.ecart.model.NavigationBadgeModel;
import com.ecart.model.NavigationChildrenModel;
import com.ecart.model.NavigationModel;
import com.ecart.repo.NavigationAttributesRepo;
import com.ecart.repo.NavigationBadgeRepo;
import com.ecart.repo.NavigationChildrenRepo;
import com.ecart.repo.NavigationRepo;
import com.ecart.searvice.NavigationService;

/**
 * @author Tharindu Jan 29, 2020
 *
 */
@Service
public class NavigationServiceImpl implements NavigationService {

	@Autowired
	private NavigationRepo navigationRepo;

	@Autowired
	private NavigationChildrenRepo navigationChildrenRepo;

	@Autowired
	private NavigationBadgeRepo navigationBadgeRepo;

	@Autowired
	private NavigationAttributesRepo navigationAttributesRepo;

	@Override
	public List<NavigationModel> getNavigation() {
		List<NavigationModel> main = new ArrayList<NavigationModel>();
		List<Navigation> naviList = navigationRepo.getNavigationTree();
		for (Navigation navigation : naviList) {
			NavigationModel row = new NavigationModel();
			List<NavigationChildren> naviChildList = navigationChildrenRepo
					.getNavigationChildByNavigationId(navigation.getNavigationId());
			NavigationBadge naviBadge = navigationBadgeRepo
					.getNavigationBadgeByNavigationId(navigation.getNavigationId());
			NavigationAttributes naviAtt = navigationAttributesRepo
					.getNavigationAttributesByNavigationId(navigation.getNavigationId());

			row.setName(navigation.getName());
			row.setIcon(navigation.getIcon());
			row.setUrl(navigation.getUrl());
			row.setSequence(navigation.getSequence());
			row.setNavigationId(navigation.getNavigationId());

			if(naviChildList!=null) {
				List<NavigationChildrenModel> mainc = new ArrayList<NavigationChildrenModel>();
				for (NavigationChildren naviChild : naviChildList) {
					if (navigation.getNavigationId() == naviChild.getNavigationId()) {
						NavigationChildrenModel rowc = new NavigationChildrenModel();
						rowc.setIcon(naviChild.getIcon());
						rowc.setName(naviChild.getName());
						rowc.setUrl(naviChild.getUrl());
						rowc.setSequence(naviChild.getSequence());
						rowc.setNavigationId(naviChild.getNavigationId());
						rowc.setNavigationChildrenId(naviChild.getNavigationChildrenId());
						mainc.add(rowc);
					}

				}
				row.setChildren(mainc);
			}else {
				List<NavigationChildrenModel> mainc =null;
				row.setChildren(null);
			}
			

			// List<NavigationBadgeModel> mainb = new ArrayList<NavigationBadgeModel>();
			// for(NavigationBadge navib:naviBadgeList) {
			
			if (naviBadge != null) {
				if (navigation.getNavigationId() == naviBadge.getNavigationId()) {
					NavigationBadgeModel rowb = new NavigationBadgeModel();
					rowb.setText(naviBadge.getText());
					rowb.setVariant(naviBadge.getVariant());
					rowb.setSequence(naviBadge.getSequence());
					rowb.setNavigationId(naviBadge.getNavigationId());
					// mainb.add(rowb);
					row.setBadge(rowb);
				}
			}
			// }
			

			// List<NavigationAttributesModel> maina = new
			// ArrayList<NavigationAttributesModel>();
			// for(NavigationAttributes navia:naviAttrList) {
			
			if (naviAtt != null) {
				if (navigation.getNavigationId() == naviAtt.getNavigationId()) {
					NavigationAttributesModel rowa = new NavigationAttributesModel();
					rowa.setDisabled(naviAtt.getDisabled());
					rowa.setSequence(naviAtt.getSequence());
					rowa.setNavigationId(naviAtt.getNavigationId());
					// maina.add(rowa);
					row.setAttributes(rowa);
				}
			}

			// }

			

			main.add(row);

		}

		return main;
	}

}
